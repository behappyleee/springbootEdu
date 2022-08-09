package com.springboot.edu.springbootEdu.data.repository;

import com.springboot.edu.springbootEdu.controller.ProductController;
import com.springboot.edu.springbootEdu.data.Entity.ProductEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.assertj.core.api.Assertions;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
public class ProductRepositoryTest {

    // Test 가 마쳤을 시에는 자동으로 Rollback 이 됨
    // BeforeEach 어노테이션을  통하여 테스트 메서드 수행전에 실행이 됨

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void generateData () {
        Long count = 1L;
        productRepository.save(getProduct(count, Math.toIntExact(count++), 2000, 3000));
        productRepository.save(getProduct(count, Math.toIntExact(count++), 3000,9000 ));
        productRepository.save(getProduct(--count, Math.toIntExact(count= count + 2), 2000,3000 ));
        productRepository.save(getProduct(count, Math.toIntExact(count++), 4000,5000 ));
        productRepository.save(getProduct(count, Math.toIntExact(count++), 10000,1500 ));
        productRepository.save(getProduct(count, Math.toIntExact(count++), 1000,1000 ));
        productRepository.save(getProduct(count, Math.toIntExact(count++), 500,10000 ));
        productRepository.save(getProduct(count, Math.toIntExact(count++), 8500,3500 ));
        productRepository.save(getProduct(count, Math.toIntExact(count++), 7200,2000 ));
        productRepository.save(getProduct(count, Math.toIntExact(count++), 5100,1700 ));
    }

    private ProductEntity getProduct(Long id, int nameNumber, int price, int stock) {
        return new ProductEntity(id, "상품" + nameNumber, price, stock);
    }

    @Test
    void findTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====================== TEST DATA =========================");
        for(ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("==================== FINISH DATA ========================");

        List<ProductEntity> foundEntitles = productRepository.findByProductName("상품4");

        for(ProductEntity productEntity : foundEntitles) {
            System.out.println("첫번째 상품 이름 : " + productEntity.toString());
        }

        List<ProductEntity> queryEntitles = productRepository.queryByProductName("상품4");

        for(ProductEntity productEntity : queryEntitles) {
            System.out.println("두번째 상품 이름 : " +productEntity.toString());
        }
    }

//    @Test
//    void existTest() {
//        List<ProductEntity>  foundAll = productRepository.findAll();
//        System.out.println("======================= TEST DATA ============================");
//
//
//    }

}
