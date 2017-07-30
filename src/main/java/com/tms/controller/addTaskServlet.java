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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Dell on 7/24/2017.
 */
@WebServlet("/addTask")
public class addTaskServlet extends HttpServlet {

    public final TaskService taskService;

    public addTaskServlet() {
        this.taskService = new TaskServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session s = Connect.createSession();

        Query query = s.createQuery("select username,id from User");

        List<User> list = query.list();
        req.setAttribute("list", list);
        req.getRequestDispatcher("addTask.jsp?adminId=" + req.getParameter("adminId")).forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // TaskDTO taskDTO = null;


        TaskDTO taskDTO = null;
        try {
            taskDTO = TaskUtils.convertRequestToDTO(req);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        taskService.addTask(taskDTO);

        req.getRequestDispatcher("addTask.jsp?adminId=" + req.getParameter("createdBy")).forward(req, resp);

    }
}
