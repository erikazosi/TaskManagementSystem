package com.tms.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Dell on 7/24/2017.
 */
@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue
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
