package com.springboot.edu.springbootEdu.data.repository;

import com.springboot.edu.springbootEdu.data.Entity.ListenerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// JPA 를 상속 받는 ListenerRepository

public interface ListenerRepository extends JpaRepository<ListenerEntity, Long> {
    

}
