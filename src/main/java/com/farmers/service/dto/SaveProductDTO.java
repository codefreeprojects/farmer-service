package com.farmers.service.dto;

import com.farmers.service.enums.ProductTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveProductDTO {
    private Long userId;
    private String productName;
    private Long quantity;
    private Long unit;
    private Long price;
    private MultipartFile productImage;
    private Date mfgDate;
    private Date expDate;
    private ProductTypeEnum productType;
}
