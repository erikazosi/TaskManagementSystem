package com.tms.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by Dell on 7/24/2017.
 */
public class Connect {

    public static Session s;
    public static SessionFactory sf;

    static {

    }


    public static org.hibernate.Session createSession() {
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        org.hibernate.Session s = sf.openSession();
        s.beginTransaction();
        return s;

    }

    public static void endSession(Session s) {
        s.getTransaction().commit();
        s.close();
        //sf.close();

    }
}
