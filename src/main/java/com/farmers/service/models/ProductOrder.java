package com.farmers.service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    @OneToOne
    private Product product;
    private Long quantity;
    private Long unit;
    private Long price;
    private Long totalPrice;
    private Boolean paymentStatus;
    private Boolean haveVehicle;
    private Boolean deliveryStatus;
    private Date orderDate;
}
