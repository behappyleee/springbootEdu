package com.springboot.edu.springbootEdu.service.impl;

import com.springboot.edu.springbootEdu.data.dto.ProductDTO;
import com.springboot.edu.springbootEdu.service.ProductService;
import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.net.ssl.HostnameVerifier;

@Service
public class ProductServiceImpl implements ProductService {

    // 필수 사항은 아니고 Handler 는 옵션 사항입
    ProductDataHandler productDataHandler;

    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler) {
        this.productDataHandler = productDataHandler;
    }
    // Entity 란 테이블이란 직접적으로 Mapping 되는 객체
    @Override
    public ProductDTO saveProduct(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);
        ProductDTO productDTO = new ProductDTO(productEntity.getProductId(),
                productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());
        return productDTO;
    }

    // Client -> Controller -> Service -> DAO -> Database
    // 클라이언트에서 컨트롤러에서 서비스에서는 각 계층간 이동은 DTO 사용
    // Service -> DAO -> Database 각 이동은 Entity 를 사용하여 데이터를 전달
    // 데이터의 변환 (DTO / Entity 변환 작업은 Service 레벨에서 해주는 게 좋음
    // 하지만 간단한 경우에는 컨트롤러에서 변환하는 경우도 있음 (각 팀마다 정하는게 좋음)

    @Override
    public ProductDTO getProduct(String productId) {
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);
        ProductDTO productDTO = new ProductDTO(productEntity.getProductId(),
                productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());
        return productDTO;
    }

}
