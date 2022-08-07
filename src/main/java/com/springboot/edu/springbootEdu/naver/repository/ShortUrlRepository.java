package com.springboot.edu.springbootEdu.naver.repository;

import com.springboot.edu.springbootEdu.naver.entity.ShortUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository 를 상속 받을 시 Jpa 기본 Method 들을 사용이 가능함
public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, Long> {
    // Jpa 는 Naming 을 통하여 쿼리 작성이 가능
    // 구현체를 만들지 않아도 Jpa가 알아서 메서드를 생성을 해 줌
    ShortUrlEntity findByUrl(String url);
    ShortUrlEntity findByOrgUrl(String originalUrl);

}
