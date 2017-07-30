package com.tms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Dell on 7/24/2017.
 */
@Setter
@Getter
public class TaskDTO {


  //  public static Object set;
    private int id;
        private Date Deadline;
        private String taskDesp;
        private String title;
        private Date createdDate;
        private int createdBy;
        private int assignedTo;
        private String status;
        private String remark;
    }


