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
@RedisHash(value = "shortUrl", timeToLive =  60)    // Redis 사용 방법
public class ShortUrlResponseDTO implements Serializable {

    private static final long serialVersionUID = 2232321321312323L;

    @Id
    private String orgUrl;

    private String shortUrl;

}
