package com.springboot.edu.springbootEdu.data.repository;
import com.springboot.edu.springbootEdu.data.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    // JPA 를 상속 받은 ProductRepository

    // 쿼리 메서드 사용하기
    // full 쿼리 메서드로 작성 시 findProductEntityProductName 이런 식으로 작성이 되어야 함
    List<ProductEntity> findByProductName(String name);
    List<ProductEntity> queryByProductName(String name);

//    TODO existByProductName 메서드 사용 시 에러가 발생함 이유 알아보기
//    boolean existByProductName(String name);

    long countByProductName(String name);

    void deleteByProductId(Long id);

//    TODO removeProductId 메서드 사용 시 에러가 발생함 이유 알아보기
//    long removeProductId(Long id);

    List<ProductEntity> findFirstByProductName(String name);

    List<ProductEntity> findTop3ByProductName(String name);

    /* 쿼리 메서드 조건자 키워드 */
    // Is, Equals 생략 가능
    // Logical Keyword : Is Keyword Expression : Is, Equals (or no keyword)
    ProductEntity findByProductIdIs(Long id);
    ProductEntity findByProductIdEquals(Long id);

    List<ProductEntity> findByProductIdNot(Long id);

//    TODO removeProductId 메서드 사용 시 에러가 발생함 이유 알아보기
//    List<ProductEntity> findByProductIdsNot(Long id);

    List<ProductEntity> findByProductStockIsNull();

    List<ProductEntity> findByProductStockIsNotNull();

    // And Or
    List<ProductEntity> findTopByProductIdAndProductName(Long id, String name);
    List<ProductEntity> findByProductPriceGreaterThan(Integer price);
    List<ProductEntity> findByProductNameContaining(String name);


}
