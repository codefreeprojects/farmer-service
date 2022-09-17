package com.farmers.service.dto;

import com.farmers.service.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotBlank;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FeedbackRequestDTO {
    @NotBlank
    private Long userId;
    @NotBlank
    private Long productId;
    private String mobileNumber;
    private Long rating;
    @NotBlank
    private String review;
}
