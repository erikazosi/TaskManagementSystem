package com.tms.dao.impl;

import com.tms.dao.TaskDao;
import com.tms.entity.Task;
import com.tms.utils.Connect;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by Dell on 7/26/2017.
 */
public class TaskDaoImpl implements TaskDao {

    public static Session session;
    public static SessionFactory sf;

    static {
        session = Connect.createSession();
    }

    public void addTask(Task task) {
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        org.hibernate.Session s = sf.openSession();
        s.beginTransaction();


        s.save(task);

        s.getTransaction().commit();
        s.close();
    }

    public boolean editTask(Task task) {

        try {
            SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
            org.hibernate.Session s = sf.openSession();
            s.beginTransaction();

            Query query = s.createQuery("update Task set taskdesp='" + task.getTaskDesp() + "',title='" + task.getTitle() + "' where id=" + task.getId());
            query.executeUpdate();

            s.getTransaction().commit();
            s.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    public void deleteTask(int id) {

    }
}
