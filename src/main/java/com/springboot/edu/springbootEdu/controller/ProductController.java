package com.springboot.edu.springbootEdu.controller;

import com.springboot.edu.springbootEdu.data.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
//
//        ProductDTO productDTO = productService.getProduct(productId);
//
//        logger.info("[getProduct] perform {} of Around Hub API", "getProduct");
//        logger.info("[getProduct] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, ResponseTime = {} ms",
//                productDTO.getProductId(),
//                productDTO.getProductName(),
//                productDTO.getProductPrice(),
//                productDTO.getProductStock(),
//                System.currentTimeMillis() - startTime
//            );
//        return productDTO;
          return productService.getProduct(productId);
    }

    @PostMapping(value ="/product")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTo) {
        String productId = productDTO.getProductId();
        String productName = productDTo.getProductName();
        int productPrice = productDTo.getProductPrice();
        int productStock = productDTo.getProductStock();

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }

    @DeleteMapping(value = "/product/{productId}")
    public ProductDTO deleteProduct() {
        return null;
    }

}
