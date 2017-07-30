package com.tms.controller;

import com.tms.dto.UsersDTO;
import com.tms.service.UserService;
import com.tms.service.impl.UserServiceImpl;
import com.tms.utils.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dell on 7/23/2017.
 */
@WebServlet("/addAdmin")
public class addAdminServlet extends HttpServlet {

    public final UserService userService;

    public addAdminServlet() {
        // todo improve
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersDTO usersDTO = UserUtils.convertRequestToDTO(req);

        userService.addAdmin(usersDTO);

        resp.sendRedirect("addAdmin.jsp");


    }


}
