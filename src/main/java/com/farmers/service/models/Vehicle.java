package com.farmers.service.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehicleName;
    @OneToOne
    private ProductOrder productOrder;
    private Long quantity;
    private Long price;
    private Long noOfDays;
    private Long totalPrice;
    private Boolean isRequired;
    private String boardingPoint;
    private String droppingPoint;
}
