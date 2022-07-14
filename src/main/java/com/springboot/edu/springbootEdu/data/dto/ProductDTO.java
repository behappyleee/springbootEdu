package com.springboot.edu.springbootEdu.data.dto;

import com.springboot.edu.springbootEdu.data.Entity.ProductEntity;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDTO {

        private String productId;
        private String productName;
        private int productPrice;
        private int productStock;

    public ProductEntity toEntity() {
        return ProductEntity.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }


}
