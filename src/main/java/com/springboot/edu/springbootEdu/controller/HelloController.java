package com.springboot.edu.springbootEdu.controller;

import com.springboot.edu.springbootEdu.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    // Logger 사용을 위하여서는 Logger 와 Logger 팩토리 클래스를 import 하여야 함 (org.slf4j 해당을 import 하여야 함)
    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    // ExceptionTest
    @PostMapping("/exception")
    public void exceptionTest() throws Exception {
        throw new Exception();
    }

    @ExceptionHandler
    public ResponseEntity<Map<String, Object>> ExceptionHandler(Exception e) {
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.info(e.getLocalizedMessage());
        LOGGER.info("Controller Exception 호출 ");

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");

        // Paramter 순서 body / header / status
        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }

    // Logger 사용법
    @PostMapping("/log-test")
    public void logTest() {
        LOGGER.trace("LOGGER TRACE MSG");
        LOGGER.debug("LOGGER DEBUG MSG");
        LOGGER.info("LOGGER INFO MSG");
        LOGGER.warn("LOGGER WARN MSG");
        LOGGER.error("LOGGER ERR MSG");
    }

}
