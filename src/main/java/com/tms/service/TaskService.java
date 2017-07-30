package com.tms.service;

import com.tms.dto.TaskDTO;
import com.tms.entity.Task;

/**
 * Created by Dell on 7/26/2017.
 */
public interface TaskService {

    void addTask(TaskDTO taskDTO);
    boolean editTask(TaskDTO taskDTO);
    void deleteTask(int id);
}
