package com.springboot.edu.springbootEdu.data.dao.impl;

import com.springboot.edu.springbootEdu.data.Entity.ProductEntity;
import com.springboot.edu.springbootEdu.data.dao.ProductDAO;
import com.springboot.edu.springbootEdu.data.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO {
    Logger LOGGER = LoggerFactory.getLogger(ProductDAOImpl.class);

    ProductRepository productRepository;
    // 스프링부트는 기본 적으로 싱글톤을 사용 객체를 Bean 으로 띄워 놓은 다음 가져다 사용하는 개념
    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        LOGGER.debug("save Product Entity : {} ", productEntity);
        ProductEntity saveProductEntity = productRepository.save(productEntity);
        return saveProductEntity;
    }

    @Override
    public ProductEntity getProduct(Long productId) {
        ProductEntity productEntity = productRepository.getById(productId);
        return productEntity;
    }
}
