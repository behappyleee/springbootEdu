package com.springboot.edu.springbootEdu.controller;

import com.springboot.edu.springbootEdu.common.Constants;
import com.springboot.edu.springbootEdu.common.exception.AroundHubException;
import com.springboot.edu.springbootEdu.data.dto.ProductDTO;
import com.springboot.edu.springbootEdu.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

    private Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product/{productId}")
    public ProductDTO getProduct(@PathVariable String productId) {
        long startTime = System.currentTimeMillis();
        // 쉼표 하나 넣을 시
        LOGGER.info("[PRODUCT CONTROLLER] perform {} of springbootEdu ", "getProduct");
        ProductDTO productDTO = productService.getProduct(productId);

        // 중괄호를 사용하여 원하는 값을 다 넣을 수 있음
        LOGGER.info("[getProduct] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, ResponseTime = {} ms",
                productDTO.getProductId(),
                productDTO.getProductName(),
                productDTO.getProductPrice(),
               productDTO.getProductStock(),
                System.currentTimeMillis() - startTime
           );
       return productDTO;
    }

    // ProductDTO 의 Validation 어노테이션을 사용하기 위하여서는 @Valid 어노테이션을 붙여준다.
    @PostMapping(value ="/product")
    public ProductDTO createProduct(@Valid @RequestBody ProductDTO productDTO) {
        String productId = productDTO.getProductId();
        String productName = productDTO.getProductName();
        int productPrice = productDTO.getProductPrice();
        int productStock = productDTO.getProductStock();

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }

    @DeleteMapping(value = "/product/{productId}")
    public ProductDTO deleteProduct() {
        return null;
    }

    // ExceptionTest 위한 메서드 (Custom Exception 을 던 짐 )
    @PostMapping(value = "/product/exception")
    public void exceptionTest () throws AroundHubException {
        throw new AroundHubException(Constants.ExceptionClass.PRODUCT, HttpStatus.BAD_REQUEST, "의도한 에러가 발생하였습니다.");
    }

}
