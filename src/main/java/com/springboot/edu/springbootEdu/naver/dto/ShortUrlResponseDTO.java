package com.springboot.edu.springbootEdu.naver.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash(value = "shortUrl", timeToLive =  60)    // Redis 사용 방법, Redis 저장 시에는 직렬화/역직렬 화가 될 수 가 있음
public class ShortUrlResponseDTO implements Serializable {

    private static final long serialVersionUID = 2232321321312323L;

    @Id // Id 어노테이션 은 반드시 org.springframework.data.annotation import 하기
    private String orgUrl;

    private String shortUrl;

}
