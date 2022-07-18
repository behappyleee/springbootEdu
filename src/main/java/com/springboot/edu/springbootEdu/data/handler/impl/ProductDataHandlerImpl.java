package com.springboot.edu.springbootEdu.data.handler.impl;

import com.springboot.edu.springbootEdu.data.Entity.ProductEntity;
import com.springboot.edu.springbootEdu.data.dao.ProductDAO;
import com.springboot.edu.springbootEdu.data.handler.ProductDataHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductDataHandlerImpl implements ProductDataHandler {

    ProductDAO productDAO;

    @Autowired
    public ProductDataHandlerImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock) {
        return null;
    }

    @Override
    public ProductEntity getProductEntity(String productId) {
        return null;
    }
}
