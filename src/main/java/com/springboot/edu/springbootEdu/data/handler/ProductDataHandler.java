package com.springboot.edu.springbootEdu.data.handler;

import com.springboot.edu.springbootEdu.data.Entity.ProductEntity;

public interface ProductDataHandler {

    ProductEntity saveProductEntity(Long productId, String productName, int productPrice, int productStock);

    ProductEntity getProductEntity(Long productId);

}
