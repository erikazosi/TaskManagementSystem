package com.tms.dao.impl;

import com.tms.dao.UserDao;
import com.tms.entity.User;
import com.tms.utils.Connect;
import com.tms.utils.UserUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Dell on 7/25/2017.
 */
public class UserDaoImpl implements UserDao {

    public static Session session;
    public static SessionFactory sf;

    static {
        session = Connect.createSession();
    }

    public void addAdmin(User user) {
        // User user = UserUtils.convertDTOToEntity(usersDTO);
        session.save(user);


      //  Connect.endSession(session);
    }

    public void editAdmin(User user) {

    }

    public void deleteAdmin(int id) {

    }

    public User findById(int id) {

        String sql = "from User where adminId=" + id;

        System.out.println(sql);
        User user = (User) UserDaoImpl.session.createQuery(sql).uniqueResult();

        return user;
    }
}
