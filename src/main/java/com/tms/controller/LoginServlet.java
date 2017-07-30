package com.tms.controller;

import com.tms.entity.User;
import com.tms.utils.BCrypt;
import com.tms.utils.Connect;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Dell on 7/24/2017.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Session s = Connect.createSession();

        Query query = s.createQuery("from User where username='" + username + "'");

        //retrieve single data
//        String hashed = (String) s.createQuery("select user.password from User user where user.username = :username").setString("username",username).uniqueResult();
//        int adminId=(Integer) s.createQuery("select user.id from User user where user.username = :username").setString("username",username).uniqueResult();

        List list = query.list();
        for (Object u : list) {
            User user = (User) u;

            if (BCrypt.checkpw(password, user.getPassword())) {
                HttpSession session = req.getSession();


                session.setAttribute("sessionId", ((User) u).getId());

                resp.sendRedirect("Sdashboard?adminId=" + user.getId());
            } else

                System.out.println("It does not match");
        }
    }

}
