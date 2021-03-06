package com.springboot.edu.springbootEdu.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class SpringBootEduException {

    private final Logger LOGGER = LoggerFactory.getLogger(SpringBootEduException.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String, Object>> ExceptionHandler() {
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.info("Advice 내 ExceptionHandler 호출");
        Map<String, Object> map = new HashMap<>();

        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");

        return new ResponseEntity(map, responseHeaders, httpStatus);
    }




}
