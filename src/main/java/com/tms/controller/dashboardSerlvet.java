package com.tms.controller;

import com.tms.dto.DashboardTaskResDto;
import com.tms.entity.Task;
import com.tms.service.UserService;
import com.tms.service.impl.UserServiceImpl;
import com.tms.utils.Connect;
import com.tms.utils.EmailTransport;
import com.tms.utils.TaskUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 7/25/2017.
 */
@WebServlet("/Sdashboard")
public class dashboardSerlvet extends HttpServlet {

    private final UserService us;

    public dashboardSerlvet() {
        this.us = new UserServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        final int id = Integer.parseInt(req.getParameter("adminId"));

        Session s = Connect.createSession();


        String adminType = (String) s.createQuery("select adminType from User where adminId=" + id).uniqueResult();


        if (adminType.equals("Super Admin")) {
            //query for pending tasks
            Query query1 = s.createQuery("from Task where status='pending'");
            List<Task> li = query1.list();
            List<DashboardTaskResDto> dashboardTaskResDtos = TaskUtils.convertToDashboardDtos(li, us);
            req.setAttribute("list", dashboardTaskResDtos);

            //query for pending tasks
            Query query2 = s.createQuery("from Task where status='complete'");
            List<Task> lii = query2.list();
            List<DashboardTaskResDto> dashboardTaskResDtos2 = TaskUtils.convertToDashboardDtos(lii, us);
            req.setAttribute("list2", dashboardTaskResDtos2);

            //query for pending tasks
            Query query = s.createQuery("from Task where status='incomplete'");
            List<Task> lis = query.list();
            List<DashboardTaskResDto> dashboardTaskResDtos3 = TaskUtils.convertToDashboardDtos(lis, us);
            req.setAttribute("list3", dashboardTaskResDtos3);


            req.getRequestDispatcher("Sdashboard.jsp?adminId=" + req.getParameter("adminId")).forward(req, resp);


        } else {
            Query query = s.createQuery("from Task where assignedTo=" + id);
            List<Task> list = query.list();

            List<DashboardTaskResDto> dashboardTaskResDtos = TaskUtils.convertToDashboardDtos(list, us);
            req.setAttribute("list", dashboardTaskResDtos);

            req.getRequestDispatcher("Adashboard.jsp?adminId=" + req.getParameter("adminId")).forward(req, resp);

        }


    }

}

    /**
     * Created by ayush.regmi on 8/6/2017.
     */
