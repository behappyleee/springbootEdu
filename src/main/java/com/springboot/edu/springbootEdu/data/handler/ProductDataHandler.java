package com.springboot.edu.springbootEdu.data.handler;

import com.springboot.edu.springbootEdu.data.Entity.ProductEntity;

public interface ProductDataHandler {

    ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);

    ProductEntity getProductEntity(String productId);

}
