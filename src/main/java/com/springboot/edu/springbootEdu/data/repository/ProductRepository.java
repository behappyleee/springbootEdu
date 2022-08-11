package com.springboot.edu.springbootEdu.data.repository;
import com.springboot.edu.springbootEdu.data.Entity.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    // JPA 를 상속 받은 ProductRepository

    // 쿼리 메서드 사용하기
    // full 쿼리 메서드로 작성 시 findProductEntityProductName 이런 식으로 작성이 되어야 함
    List<ProductEntity> findByProductName(String name);
    List<ProductEntity> queryByProductName(String name);

    boolean existsByProductName(String name);

    long countByProductName(String name);

    void deleteByProductId(Long id);

    long removeByProductId(Long id);
    List<ProductEntity> findFirst5ByProductName(String name);

    List<ProductEntity> findTop3ByProductName(String name);

    /* 쿼리 메서드 조건자 키워드 */
    // Is, Equals 생략 가능
    // Logical Keyword : Is Keyword Expression : Is, Equals (or no keyword)
    ProductEntity findByProductIdIs(Long id);
    ProductEntity findByProductIdEquals(Long id);

    List<ProductEntity> findByProductIdNot(Long id);

    List<ProductEntity> findByProductIdIsNot(Long id);

    List<ProductEntity> findByProductStockIsNull();

    List<ProductEntity> findByProductStockIsNotNull();

    // And Or
    List<ProductEntity> findTopByProductIdAndProductName(Long id, String name);

    // (Is)GreaterThan / (Is)LessThan / (Is)Between
    List<ProductEntity> findByProductPriceGreaterThan(Integer price);
    // (Is)Like / (Is)Containing / (Is)StartingWith / (Is)EndingWith
    List<ProductEntity> findByProductNameContaining(String name);

    /* 정렬과 페이징 */
    // ASC : 오름차순 DESC : 내림차순 (Containing 은 부분조회 부분적으로 일치하면 데이터를 조회)
    List<ProductEntity> findByProductNameContainingOrderByProductStockAsc(String name);
    List<ProductEntity> findByProductNameContainingOrderByProductStockDesc(String name);

    // 여러 정렬 기준 사용
    List<ProductEntity> findByProductNameContainingOrderByProductPriceAscProductStockDesc(String name);

    // 매개 변수를 활용한 정렬
    List<ProductEntity> findByProductNameContaining(String name, Sort sort);

    // 페이징 처리하기
    List<ProductEntity> findByProductPriceGreaterThan(Integer price, Pageable pageable);

}
