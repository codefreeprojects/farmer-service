package com.farmers.service.dto;

import com.farmers.service.enums.UserRoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String userName;
    private String mobileNumber;
    private String address;
    private String city;
    private Long zip;
    private String password;
    @NotBlank
    private UserRoleEnum role;
}
