package com.tms.service;

import com.tms.dto.UsersDTO;
import com.tms.entity.User;

/**
 * Created by Dell on 7/25/2017.
 */
public interface UserService {

    void addAdmin(UsersDTO usersDTO);
    User findById(int id);
//    void editAdmin(UsersDTO usersDTO);
//    void deleteAdmin(UsersDTO usersDTO);

}
