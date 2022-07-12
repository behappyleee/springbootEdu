package com.springboot.edu.springbootEdu.controller;

import com.springboot.edu.springbootEdu.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    @PutMapping(value = "/default")
    public String putMethod() {
        return "Hello World";
    }

    @PutMapping
    public String postMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();
        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue()+ "\n");
        });
        return sb.toString();
    }

    // return 을 String 으로 return
    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }

    // memberDTO 를 return
    @PutMapping(value = "/member2")
    public MemberDTO postMemberDto2(@RequestBody MemberDTO memberDTO) {
        return memberDTO;
    }

    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDTO> postMemberDto3(@RequestBody MemberDTO memberDTO) {
        // memberDTO 를 ResponseEntity 를 이용하여 return
        // responseStatusCode 가 202로 return 함
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
    }




}
