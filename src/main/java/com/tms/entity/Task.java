package com.tms.entity;

import javafx.beans.DefaultProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @Temporal(TemporalType.DATE)
    private Date Deadline;
    private String taskDesp;
    private String title;
    private Date createdDate;
    private int createdBy;
    private int assignedTo;
    private String status;
    private String remark;

    //@Column(columnDefinition = "default'n'")
    private String notify;

    private String fileUpload;
}
