//package com.tms.controller;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
///**
// * Created by Dell on 7/23/2017.
// */
//
//@WebServlet(".jsp")
//public class MainController extends HttpServlet{
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//
// //       resp.sendRedirect("index.jsp");
////        HttpSession session = req.getSession();
////
////
////        session.setAttribute("sessionId", ((User) uu).getUserId());
//        req.getRequestDispatcher("index.jsp").forward(req, resp);
//    }
//
//
//}
