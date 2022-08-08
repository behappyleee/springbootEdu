package com.springboot.edu.springbootEdu.service;

import com.springboot.edu.springbootEdu.data.dto.ProductDTO;

public interface ProductService {
    // interface 와 class 로 설계하는 기법은 Loose Coupling 기법이라 함
    // LooseCoupling 사용을 원치 않을 시 interface 구현 없이 바로 Class 로 구현
    // interface 와 class 로 구현하는 방법은 Loose Coupling 사용 구현 방법이라 함
    // 각 객체들간의 의존성을 줄여주는 역할을 함
    ProductDTO saveProduct(Long productId, String productName, int productPrice, int productStock);

    ProductDTO getProduct(Long productId);
}
