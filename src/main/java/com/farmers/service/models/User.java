package com.farmers.service.models;

import com.farmers.service.enums.UserRoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String mobileNumber;
    private String address;
    private String city;
    private Long zip;
    @JsonIgnore
    private String password;
    private UserRoleEnum role;
    private Date createdOn;
    private Boolean status;
}
