package com.springboot.edu.springbootEdu.naver.repository;

import com.springboot.edu.springbootEdu.naver.entity.ShortUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, Long> {

    ShortUrlEntity findByUrl(String url);

    ShortUrlEntity findByOrgUrl(String originalUrl);
}
