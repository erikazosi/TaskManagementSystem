package com.tms.controller;

import com.tms.dto.TaskDTO;
import com.tms.entity.User;
import com.tms.service.TaskService;
import com.tms.service.impl.TaskServiceImpl;
import com.tms.utils.Connect;
import com.tms.utils.TaskUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Dell on 7/24/2017.
 */

@WebServlet("/addTask")
@MultipartConfig(maxFileSize = 1073741824)
public class addTaskServlet extends HttpServlet {

    public final TaskService taskService;

    public addTaskServlet() {
        this.taskService = new TaskServiceImpl();
    }

    private static final String SAVE_DIR = "uploadFiles";


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session s = Connect.createSession();

        Query query = s.createQuery("select username,id from User");

        List<User> list = query.list();
        request.setAttribute("list", list);
        request.getRequestDispatcher("addTask.jsp?adminId=" + request.getParameter("adminId")).forward(request, response);


    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;


        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }


        Collection<Part> parts = request.getParts();
        Part fileUpload = request.getPart("fileUpload");

        String s = extractFileName(fileUpload);

        fileUpload.write(savePath + File.separator + s);


        TaskDTO taskDTO = null;
        try

        {
            taskDTO = TaskUtils.convertRequestToDTO(request,s);

        } catch (
                ParseException e)

        {
            e.printStackTrace();
        }

        taskService.addTask(taskDTO);


        request.getRequestDispatcher("addTask.jsp?adminId=" + request.getParameter("createdBy")).forward(request, response);
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

}
