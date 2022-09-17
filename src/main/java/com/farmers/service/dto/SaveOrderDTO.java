package com.farmers.service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaveOrderDTO {
    private Long userId;
    private Long productId;
    private Long quantity;
    private Long unit;
    private Long price;
    private Long totalPrice;
    private Boolean paymentStatus;
    private Boolean haveVehicle;
    private SaveVehicleDTO vehicleDetails;
}
