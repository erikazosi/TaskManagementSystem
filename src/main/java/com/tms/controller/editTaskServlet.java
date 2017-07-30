package com.tms.controller;

import com.tms.dto.TaskDTO;
import com.tms.entity.Task;
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
 * Created by Dell on 7/26/2017.
 */

@WebServlet("/edit")
public class editTaskServlet extends HttpServlet {
    public final TaskService taskService;


    public editTaskServlet() {
        this.taskService = new TaskServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("here");
        Session s = Connect.createSession();

        Query query = s.createQuery("select taskDesp,title,status,assignedTo from Task where id=" + req.getParameter("taskId"));

        List list = query.list();

        req.setAttribute("list", list);
        req.getRequestDispatcher("edit.jsp?adminId=" + req.getParameter("adminId")).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session s = Connect.createSession();
        Query q = s.createQuery("from Task where id=" + req.getParameter("taskId"));
        // Object t = q.uniqueResult();

        System.out.println(req.getParameter("adminId"));

        int id = Integer.parseInt(req.getParameter("taskId"));

        try {
            TaskDTO taskDTO = TaskUtils.convertEditRequestToDTO(req, id);
            if (taskService.editTask(taskDTO)) {
                System.out.println(req.getParameter("adminId"));
                resp.sendRedirect("Sdashboard?adminId=" + req.getParameter("adminId"));
            } else {
                System.out.println("You have an error!");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
