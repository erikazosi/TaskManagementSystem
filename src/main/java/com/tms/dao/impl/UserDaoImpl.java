package com.tms.dao.impl;

import com.tms.dao.UserDao;
import com.tms.entity.User;
import com.tms.utils.Connect;
import com.tms.utils.UserUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

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
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        org.hibernate.Session s = sf.openSession();
        s.beginTransaction();
        s.save(user);

        s.getTransaction().commit();
        s.close();


      // Connect.endSession(session);
    }


    public User findById(int id) {

        String sql = "from User where adminId=" + id;

        System.out.println(sql);
        User user = (User) UserDaoImpl.session.createQuery(sql).uniqueResult();

        return user;
    }
}
