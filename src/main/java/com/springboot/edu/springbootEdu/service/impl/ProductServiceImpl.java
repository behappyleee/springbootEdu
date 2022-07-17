package com.springboot.edu.springbootEdu.service.impl;

import com.springboot.edu.springbootEdu.data.dto.ProductDTO;
import com.springboot.edu.springbootEdu.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    // 필수 사항은 아니고 Handler 는 옵션 사항입
    ProductDataHandler productDataHandler;
ㄴ
    @Override
    public ProductDTO saveProduct(String productId, String productName, int productPrice, int productStock) {
        return null;
    }

    @Override
    public ProductDTO getProduct(String productId) {
        return null;
    }
}
