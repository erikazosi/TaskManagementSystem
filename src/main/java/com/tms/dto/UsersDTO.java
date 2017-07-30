package com.tms.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

/**
 * Created by Dell on 7/23/2017.
 */
@Getter
@Setter
public class UsersDTO {

    private int id;
    private String fullName;
    private String adminType;
    private String username;
    private String password;
    private Date createdDate;
    private String status;

}
