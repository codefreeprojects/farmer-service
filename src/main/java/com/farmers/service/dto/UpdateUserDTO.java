package com.farmers.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String address;
    private String city;
    private Long zip;
    private String password;
}
