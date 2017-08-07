package com.tms.controller;

import com.tms.entity.Task;
import com.tms.utils.EmailTransport;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import javax.mail.MessagingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DeadlineCheck implements Runnable {

    public void run() {
        System.out.println("check");
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        Session ss = sf.openSession();
        ss.beginTransaction();

        Query queryy = ss.createQuery("from Task where notify='n'");
        List<Task> listt = queryy.list();
        //   Date currentDate = null;

        for (Task t : listt) {
            Date deadline = t.getDeadline();

            DateFormat sqlDateFormatter = new SimpleDateFormat("yyyy-MM-dd");

            java.sql.Date currentDate = java.sql.Date.valueOf(sqlDateFormatter.format(new Date()));


            Object id = ss.createQuery("select assignedTo from Task where id=" + t.getId()).uniqueResult();
            if (id == null) continue;

            Object email = ss.createQuery("select email from User where id=" + id ).uniqueResult();
            System.out.println(deadline.after(currentDate));
            if (deadline.after(currentDate)) {
                try {
                    EmailTransport.generateAndSendEmail((email.toString()));
                    System.out.println("email sent");

                    Query q = ss.createQuery("update Task set notify='y' where id=" + t.getId());
                    q.executeUpdate();

                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }


        }


        ss.getTransaction().commit();
        ss.close();
    }
}

