package com.tms.utils;

import com.tms.dto.DashboardTaskResDto;
import com.tms.entity.Task;
import com.tms.dto.TaskDTO;
import com.tms.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 7/24/2017.
 */
public class TaskUtils {
    public static TaskDTO convertRequestToDTO(HttpServletRequest req,String fileName) throws ParseException {
        TaskDTO taskDTO = new TaskDTO();

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        taskDTO.setCreatedDate(formatter.parse(formatter.format(new Date())));
        taskDTO.setCreatedBy(Integer.parseInt(req.getParameter("createdBy")));
        taskDTO.setAssignedTo(Integer.parseInt(req.getParameter("assignTo")));
        taskDTO.setDeadline(formatter.parse(req.getParameter("deadline")));
        taskDTO.setStatus("pending");
        taskDTO.setTitle(req.getParameter("title"));
        taskDTO.setTaskDesp(req.getParameter("desc"));
        taskDTO.setNotify("n");
        taskDTO.setFileUpload(fileName);

        return taskDTO;

    }

    public static TaskDTO convertEditRequestToDTO(HttpServletRequest req, int id) throws ParseException {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle(req.getParameter("title"));
        taskDTO.setTaskDesp(req.getParameter("taskDesp"));
        taskDTO.setId(id);

        return taskDTO;

    }

    public static Task convertRequestToEntity(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setTaskDesp(taskDTO.getTaskDesp());
        task.setDeadline(taskDTO.getDeadline());
        task.setCreatedBy(taskDTO.getCreatedBy());
        task.setCreatedDate(taskDTO.getCreatedDate());
        task.setAssignedTo(taskDTO.getAssignedTo());
        task.setStatus(taskDTO.getStatus());
        task.setNotify(taskDTO.getNotify());
        task.setFileUpload(taskDTO.getFileUpload());

        return task;

    }

    public static TaskDTO convertEntityToDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskDesp(task.getTaskDesp());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDeadline(task.getDeadline());

        return taskDTO;
    }


    //todo divide
    public static List<DashboardTaskResDto> convertToDashboardDtos(List<Task> tasks, UserService us) {

        List<DashboardTaskResDto> result = new ArrayList<DashboardTaskResDto>();
        for (Task task : tasks) {
            DashboardTaskResDto dash = new DashboardTaskResDto();
            dash.setDeadline(task.getDeadline());
            dash.setTitle(task.getTitle());
            dash.setCreatedDate(task.getCreatedDate());
            dash.setTaskDesp(task.getTaskDesp());
            dash.setStatus(task.getStatus());
            //  dash.setAssignedTo(us.findById(task.getAssignedTo()).getUsername());
            dash.setCreatedBy(us.findById(task.getCreatedBy()).getUsername());
            dash.setTaskId(task.getId());
            dash.setRemark(task.getRemark());
            dash.setFileUpload(task.getFileUpload());
            result.add(dash);
        }


        return result;
    }
}
