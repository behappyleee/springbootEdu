package com.springboot.edu.springbootEdu.data.dao.impl;

import com.springboot.edu.springbootEdu.data.Entity.ProductEntity;
import com.springboot.edu.springbootEdu.data.dao.ProductDAO;
import com.springboot.edu.springbootEdu.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO {

    ProductRepository productRepository;
    // 스프링부트는 기본 적으로 싱글톤을 사용 객체를 Bean 으로 띄워 놓은 다음 가져다 사용하는 개념
    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId) {
        ProductEntity productEntity = productRepository.getById(productId);
        return productEntity;
    }
}
