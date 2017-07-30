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
 * Created by Dell on 7/27/2017.
 */
@WebServlet("/addRemark")
public class addRemarkSevlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String remark = req.getParameter("remark");
        String taskId = req.getParameter("taskId");
        String adminId = req.getParameter("adminId");


        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        org.hibernate.Session s = sf.openSession();
        s.beginTransaction();

        Query query = s.createQuery("Update Task set remark='" + remark + "'where id=" + taskId);
        query.executeUpdate();


        s.getTransaction().commit();
        s.close();
        sf.close();
        resp.sendRedirect("Sdashboard?adminId=" + adminId);
    }
}
