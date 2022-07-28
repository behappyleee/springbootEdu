package com.springboot.serverbox.controller;

import com.springboot.serverbox.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/server")
public class TestController {

    private final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @GetMapping(value="/around-hub")
    public String getTest() {
        LOGGER.info("/aroung-hub controller");
        return "Hello, Around Hub Studio";
    }

    @GetMapping(value = "/name")
    public String getTest2(@RequestParam String name) {
        LOGGER.info("/name TestController");
        return "Hello. " + name + " ! ";
    }

    @GetMapping(value = "/path-variable/{name}")
    public String getTest3(@PathVariable String name) {
        LOGGER.info("get Test3 호출");
        return "Hello : " + name + " ! ";
    }

    @PostMapping(value ="/member")
    public ResponseEntity<MemberDTO> getMember(
        // 값을 넘겨 줄 시 uri paramter 로 들어가 있는 값 은 RequestParam 으로 받으며
        // 객체로 넘겨준 값은 RequestBody 를 통하여 값을 받는다.
        @RequestBody MemberDTO memberDTO,
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String organization
    ) {
        LOGGER.info("getMember 호출 !!");
        
        MemberDTO memberDTO1 = new MemberDTO();
        memberDTO1.setName(name);
        memberDTO1.setEmail(email);
        memberDTO1.setOrganization(organization);
        
        // 값을 반환 시 memberDTO 는 RequestBody 값 을 반환을 하고 memberDTO1 은 RequestParam 값 을 반환
        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
    }

    @PostMapping(value = "/add-header")
    public ResponseEntity<MemberDTO> addHeader(@RequestHeader("around-hub") String header, @RequestBody MemberDTO memberDTO) {
        // Header 값에는 보통 Authentification 값 을 보통 많이 넣어 사용
        // 인증 받아 사용할 시
        LOGGER.info("addHeader Controller 호출 !");
        LOGGER.info("header 값 :  {} " , header);
        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
    }



}
