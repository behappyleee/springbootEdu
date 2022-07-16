package com.springboot.edu.springbootEdu.controller;

import com.springboot.edu.springbootEdu.ProductService;
import com.springboot.edu.springbootEdu.data.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/product-api")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product/{productId}")
    public ProductDTO getProduct(@PathVariable String productId) {
        long startTime = System.currentTimeMillis();

        ProductDTO productDTO = productService.getProduct(productId);

        logger.info("[getProduct] perform {} of Around Hub API", "getProduct");
        logger.info("[getProduct] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, ResponseTime = {} ms",
                productDTO.getProductId(),
                productDTO.getProductName(),
                productDTO.getProductPrice(),
                productDTO.getProductStock(),
                System.currentTimeMillis() - startTime
            );
        return productDTO;
    }






}
