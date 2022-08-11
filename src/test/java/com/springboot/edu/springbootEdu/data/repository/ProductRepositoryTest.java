package com.springboot.edu.springbootEdu.data.repository;

import com.springboot.edu.springbootEdu.controller.ProductController;
import com.springboot.edu.springbootEdu.data.Entity.ProductEntity;
import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.assertj.core.api.Assertions;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

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

    @Test
    void existTest() {
        List<ProductEntity>  foundAll = productRepository.findAll();

        System.out.println("foudn All Data :" + foundAll);

        System.out.println("======================= TEST DATA ============================");
        for(ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("==================== TEST DATA END ==========================");
        // exists 존재 하는 지 확인 return boolean 값
        System.out.println("상품 4 조회 결과 : " + productRepository.existsByProductName("상품 4"));    
        System.out.println("상품 2 조회 결과 : " + productRepository.existsByProductName("상품 2"));
    }

    @Test
    void countTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("=============== TEST DATA =================");

        for(ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("================ TEST END ========================");
        System.out.println("count By ProductName : " + productRepository.countByProductName("상품4"));
    }

    // 삭제 테스트를 진행하기 위하여서는 반드시 Transcational 어노테이션을 붙여주어야 함
    @Test
    @Transactional
    void deleteData() {
        System.out.println("before : "  + productRepository.count());
        productRepository.deleteByProductId(1L);    // 해당 productIㅇ tkrwp
        productRepository.removeByProductId(9L);
        System.out.println("After : " + productRepository.count());
    }

    @Test
    void topTest() {
        productRepository.save(getProduct(100L, 123, 1500, 5000));
        productRepository.save(getProduct(101L, 123, 1500, 5000));
        productRepository.save(getProduct(102L, 123, 1500, 5000));
        productRepository.save(getProduct(103L, 123, 1500, 5000));
        productRepository.save(getProduct(104L, 123, 1500, 5000));
        productRepository.save(getProduct(105L, 123, 1500, 5000));
        productRepository.save(getProduct(106L, 123, 1500, 5000));
        productRepository.save(getProduct(107L, 123, 1500, 5000));

        List<ProductEntity> foundEntitles = productRepository.findFirst5ByProductName("상품123");
        System.out.println("상품 5 조회 : " + foundEntitles.toString());
        for(ProductEntity productEntity : foundEntitles) {
            System.out.println("상품 조회 : " + productEntity.toString());
        }
        List<ProductEntity> foundEntitles2 = productRepository.findTop3ByProductName("상품123");
        for(ProductEntity productEntity : foundEntitles2) {
            System.out.println("productEntity : " + productEntity.toString());
        }
    }

    /* 조건자 키워드 테스트 */
    @Test
    void isEuqalsTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("=================== TEST DATA START =======================");
        for(ProductEntity productEntity : foundAll) {
            System.out.println("ProductEntity : " + productEntity.toString());
        }
        System.out.println("=================== TEST DATA END =========================");
        System.out.println("findById Is : " + productRepository.findByProductIdIs(1L));
        System.out.println("findByProductEquals " + productRepository.findByProductIdEquals(1L));
    }

    @Test
    void notTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("================= TEST DATA START ======================");

        for(ProductEntity productEntity : foundAll) {
            System.out.println("ProductEntity : " + productEntity.toString() );
        }

        List<ProductEntity> foundEntitles = productRepository.findByProductIdIsNot(1L);

        for(ProductEntity productEntity : foundEntitles) {
            System.out.println("FoundEntitls productEntity : " + productEntity.toString());
        }

        System.out.println("ProductEntitiy IsNot : " + productRepository.findByProductIdIsNot(1L));
        System.out.println("=============== TEST DATA END ==========================");
    }

    @Test
    void nullTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("TEST DATA START !!!");
        for(ProductEntity productEntity : foundAll) {
            System.out.println("Product Found : "  + productEntity.toString());
        }
        System.out.println("TEST DATA END !!!!!");
        System.out.println("isNull : " + productRepository.findByProductStockIsNull());
        System.out.println("isNotNull : " + productRepository.findByProductStockIsNotNull());
    }

    @Test
    void andTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("TEST STARTT");
        for(ProductEntity productEntity : foundAll) {
            System.out.println("productEntity data : " + productEntity.toString());
        }
        System.out.println("TEST ENDDD");
        System.out.println(productRepository.findTopByProductIdAndProductName(1L, "상품1"));
    }

    @Test
    void greaterTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("TEST STARTTTT");
        for(ProductEntity productEntity : foundAll) {
            System.out.println("productString : " + productEntity.toString());
        }
        System.out.println("TEST ENDDDD");
        // 가격이 5000 이상인 값만 가져 옴
        List<ProductEntity> productEntities = productRepository.findByProductPriceGreaterThan(5000);
        for(ProductEntity productEntity : productEntities) {
            System.out.println("ProductEntity : " + productEntity.toString());
        }
    }

    @Test
    void containTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("TEST STARTTTT");
        for(ProductEntity productEntity : foundAll) {
            System.out.println("productString : " + productEntity.toString());
        }
        System.out.println("TEST ENDDDD");
        // 상품 1이 포함이 된 값만 가져옴
        System.out.println(productRepository.findByProductNameContaining("상품1"));
    }

    /* 정렬과 페이징 */

    @Test
    public void orderByTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("============= TEST START ==================");
        for (ProductEntity productEntity : foundAll) {
            System.out.println("Product String : " + productEntity.toString());
        }
        System.out.println("=============== TEST END =======================");

        List<ProductEntity> foundProduct = productRepository.findByProductNameContainingOrderByProductStockAsc("상품");

        for (ProductEntity product : foundProduct) {
            System.out.println("Stock Asc : " + product.toString());
        }

        foundProduct = productRepository.findByProductNameContainingOrderByProductStockDesc("상품");
        for (ProductEntity product : foundProduct) {
            System.out.println("Containing Order By Stock : " + product.toString());
        }

        foundProduct = productRepository.findByProductNameContainingOrderByProductPriceAscProductStockDesc("상품");
        for (ProductEntity product : foundProduct) {
            System.out.println("Order Pridce Asc Stock Desc : " + product.toString());
        }

    }



}
