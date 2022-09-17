package com.farmers.service.models;

import com.farmers.service.enums.ProductTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Long quantity;
    private Long unit;
    private Long price;
    private String imageUrl;
    private Date mfgDate;
    private Date expDate;
    private ProductTypeEnum productType;
    @OneToOne
    private User user;
}
