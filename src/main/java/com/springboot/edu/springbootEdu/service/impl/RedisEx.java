package com.springboot.edu.springbootEdu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class RedisEx {

    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public RedisEx(RedisTemplate<String, String> redisTemplate) {
       this.redisTemplate = redisTemplate;
    }
    
    // Redis 사용 방법 (Redis 에 다가 key / value 를 사용 하여 Redis 에 등록이 가능함)
    public void redisTest() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("key" , "value");
    }

}
