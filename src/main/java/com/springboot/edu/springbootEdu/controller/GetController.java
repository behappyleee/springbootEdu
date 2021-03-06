package com.springboot.edu.springbootEdu.controller;

import com.springboot.edu.springbootEdu.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping(value = "/api/v1/get-api")  // 해당 클래 스 공통 URL
public class GetController {

    Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    // 만약 ReuqestMapping 에 URL 만 기입 시 POST / GET / DELETE / PATCH 아무 Method 를 사용하여도 응답을 함
    // @RequestMapping("/hello")
    @GetMapping("/hello")   // GetMapping 이 더 최신 어노테이션 ReuqestMapping 이 조금 더 올드 함
    public String hello() {
        return "Hello World Hello Contoller !";
    }

    //    RequestMapping 사용 법
//    @RequestMapping(value="/hello" method= RequestMethod.GET)
//    public String hello() {
//        return "HelloWorld ";
//    }
    @RequestMapping(value="/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    @RequestMapping(value="/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    @GetMapping("/request1")
    public String request1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization
    ) {
        return name + "" + "" + email + "" + organization;
    }

    @GetMapping("/request2")
    public String request2(@RequestParam Map<String, Object> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    // classDTO 를 사용하여 param 을 받아오는 방법 DTO 에 선언된 fields 들 을 RequestParam 속성으로 값을 가져옴
    @GetMapping("/request3")
    public String request3(MemberDTO memberDTO) {
        return memberDTO.toString();
    }



}
