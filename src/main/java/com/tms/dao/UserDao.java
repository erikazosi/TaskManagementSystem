package com.tms.dao;

import com.tms.entity.User;

/**
 * Created by Dell on 7/25/2017.
 */
public interface UserDao {
    void addAdmin(User user);


    User findById(int id);
}
