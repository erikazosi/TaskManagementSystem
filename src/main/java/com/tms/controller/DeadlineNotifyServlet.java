package com.tms.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by ayush.regmi on 8/6/2017.
 */

@WebListener
public class DeadlineNotifyServlet implements ServletContextListener{
    private ScheduledExecutorService scheduler;


    public void contextInitialized(ServletContextEvent event) {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        // scheduler.scheduleAtFixedRate(new DailyJob(), 0, 1, TimeUnit.DAYS);
        System.out.println("start");
        scheduler.scheduleAtFixedRate(new DeadlineCheck(), 0, 5, TimeUnit.DAYS);
        //scheduler.scheduleAtFixedRate(new MinJob(), 0, 1, TimeUnit.MINUTES);
        // scheduler.scheduleAtFixedRate(new SecJob(), 0, 15, TimeUnit.SECONDS);
    }


    public void contextDestroyed(ServletContextEvent event) {
        scheduler.shutdownNow();
    }

}
