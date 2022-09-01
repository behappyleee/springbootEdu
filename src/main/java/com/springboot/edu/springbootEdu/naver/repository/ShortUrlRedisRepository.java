package com.springboot.edu.springbootEdu.naver.repository;

import com.springboot.edu.springbootEdu.naver.dto.ShortUrlResponseDTO;
import org.springframework.data.repository.CrudRepository;

// Repository 를 활용한 Redis 사용 방법 (JpaRepository 가 아닌 CrudRepository 를 사용)
public interface ShortUrlRedisRepository extends CrudRepository<ShortUrlResponseDTO, String> {




}
