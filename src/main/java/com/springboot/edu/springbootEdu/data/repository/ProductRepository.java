package com.springboot.edu.springbootEdu.data.repository;
import com.springboot.edu.springbootEdu.data.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    // JPA 를 상속 받은 ProductRepository


}
