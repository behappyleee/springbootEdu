package com.springboot.edu.springbootEdu.data.dao;

import com.springboot.edu.springbootEdu.data.Entity.ProductEntity;

public interface ProductDAO {

    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(String productId);
}
