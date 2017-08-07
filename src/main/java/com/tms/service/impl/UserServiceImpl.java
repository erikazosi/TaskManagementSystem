package com.tms.service.impl;

import com.tms.dao.UserDao;
import com.tms.dao.impl.UserDaoImpl;
import com.tms.dto.UsersDTO;
import com.tms.entity.User;
import com.tms.service.UserService;
import com.tms.utils.UserUtils;

/**
 * Created by Dell on 7/25/2017.
 */
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }


    public void addAdmin(UsersDTO usersDTO) {
        User user= UserUtils.convertDTOToEntity(usersDTO);

        userDao.addAdmin(user);
    }

    public User findById(int id) {
        return userDao.findById(id);
    }
}
