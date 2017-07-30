package com.tms.dao;

import com.tms.entity.Task;
import com.tms.entity.User;

/**
 * Created by Dell on 7/26/2017.
 */
public interface TaskDao {
    void addTask(Task task);
    boolean editTask(Task task);
    void deleteTask(int id);

    //User findById(int id);
}
