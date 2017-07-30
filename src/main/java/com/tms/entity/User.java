package com.tms.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dell on 7/23/2017.
 */

@Entity
@Getter
@Setter
@Table(name = "users_tbl")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "adminId")
    private int id;
    private String adminType;
    private String username;
    private String password;

    //@Column(nullable = false, columnDefinition = "int default 100")
    private Date createdDate;
    private String status;


}
