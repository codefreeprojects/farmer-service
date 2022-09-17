package com.farmers.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data @NoArgsConstructor @AllArgsConstructor
public class LoginRequestDTO {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}
