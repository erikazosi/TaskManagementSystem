package com.tms.service.impl;

import com.tms.dao.TaskDao;
import com.tms.dao.impl.TaskDaoImpl;
import com.tms.dto.TaskDTO;
import com.tms.entity.Task;
import com.tms.service.TaskService;
import com.tms.utils.TaskUtils;

/**
 * Created by Dell on 7/26/2017.
 */
public class TaskServiceImpl implements TaskService {

    private final TaskDao taskDao;

    public TaskServiceImpl() {
        this.taskDao = new TaskDaoImpl();
    }

    public void addTask(TaskDTO taskDTO) {
        Task task= TaskUtils.convertRequestToEntity(taskDTO);
        taskDao.addTask(task);
    }

    public boolean editTask(TaskDTO taskDTO) {
        Task task=TaskUtils.convertRequestToEntity(taskDTO);
        return taskDao.editTask(task);
    }

    public void deleteTask(int id) {

    }
}
