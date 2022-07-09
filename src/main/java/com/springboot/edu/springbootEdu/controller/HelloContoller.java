package com.springboot.edu.springbootEdu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContoller {

    // 만약 ReuqestMapping 에 URL 만 기입 시 POST / GET / DELETE / PATCH 아무 Method 를 사용하여도 응답을 함
    // @RequestMapping("/hello")
    @GetMapping("/hello")   // GetMapping 이 더 최신 어노테이션 ReuqestMapping 이 조금 더 올드 함
    public String hello() {
        return "Hello World Hello Contoller !";
    }

}
