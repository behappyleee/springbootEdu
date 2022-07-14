package com.springboot.edu.springbootEdu.data.Entity;

import com.springboot.edu.springbootEdu.data.dto.ProductDTO;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


// 만약 아래 어노테이션을 하나로 @Data 로 어노테이션 사용하여도 됨
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="product")
public class ProductEntity {

    @Id
    String productId;
    String productName;
    Integer productPrice;
    Integer productStock;

    public ProductDTO toDto() {
        return ProductDTO.builder().build();
    }

}
