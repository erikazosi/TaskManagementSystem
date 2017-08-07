package com.tms.utils;

import com.tms.entity.User;
import com.tms.dto.UsersDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Dell on 7/24/2017.
 */
public class UserUtils {
    public static UsersDTO convertRequestToDTO(HttpServletRequest req){
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setUsername(req.getParameter("username"));
        String hashed = BCrypt.hashpw(req.getParameter("password"), BCrypt.gensalt(12));

        usersDTO.setPassword(hashed);
        usersDTO.setAdminType(req.getParameter("adminType"));
        usersDTO.setCreatedDate(new java.sql.Date(new Date().getTime()));
        usersDTO.setEmail(req.getParameter("email"));

        return usersDTO;
    }

    public static User convertDTOToEntity(UsersDTO usersDTO){
        User user = new User();
        user.setUsername(usersDTO.getUsername());
        user.setPassword(usersDTO.getPassword());
        user.setAdminType(usersDTO.getAdminType());
        user.setEmail(usersDTO.getEmail());

        return user;
    }
}
