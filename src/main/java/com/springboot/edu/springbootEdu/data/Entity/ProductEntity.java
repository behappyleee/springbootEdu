package com.springboot.edu.springbootEdu.data.Entity;

import com.springboot.edu.springbootEdu.data.dto.ProductDTO;
import com.springboot.edu.springbootEdu.naver.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;


// 만약 아래 어노테이션을 하나로 @Data 로 어노테이션 사용하여도 됨
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString   // toString 값을 추가 Entity 값을 더 쉽게 조회가 가능
@Table(name="product")
public class ProductEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productId;
    String productName;
    Integer productPrice;
    Integer productStock;

    public ProductDTO toDto() {
        return ProductDTO.builder().build();
    }

}
