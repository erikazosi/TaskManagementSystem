package com.tms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Dell on 7/25/2017.
 */
@Getter
@Setter
public class DashboardTaskResDto {

   private int taskId;
    private Date Deadline;
    private String taskDesp;
    private String title;
    private Date createdDate;
    private String createdBy;
    private String assignedTo;
    private String status;
    private String remark;
    private String fileUpload;
}
