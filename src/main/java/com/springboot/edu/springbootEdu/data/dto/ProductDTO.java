package com.springboot.edu.springbootEdu.data.dto;

import com.springboot.edu.springbootEdu.data.Entity.ProductEntity;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDTO {
        // 어노테이션을 이용 하여 Validation Library를 활용
        @NotNull
        // @Size(min =0, max=0)
        private String productId;
        @NotNull
        private String productName;
        @NotNull
        @Min(value = 500)
        @Max(value = 30000000)
        private int productPrice;
        @NotNull
        @Min(value = 0)
        @Max(value = 9999)
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
