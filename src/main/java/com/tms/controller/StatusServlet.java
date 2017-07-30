package com.tms.controller;

import com.tms.utils.Connect;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dell on 7/26/2017.
 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String status = req.getParameter("status");
        String id = req.getParameter("taskId");
        String admin = req.getParameter("adminId");

        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        org.hibernate.Session s = sf.openSession();
        s.beginTransaction();

        if (status.equals("Completed")) {

            Query query = s.createQuery("Update Task set status='complete' where id=" + id);
            query.executeUpdate();
            resp.sendRedirect("/Sdashboard?adminId=" + admin);


        } else {
            Query query = s.createQuery("Update Task set status='incomplete' where id=" + id);
            query.executeUpdate();
            resp.sendRedirect("/Sdashboard?adminId=" + admin);

        }

        s.getTransaction().commit();
        s.close();


    }
}
