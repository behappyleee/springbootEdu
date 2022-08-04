package com.springboot.edu.springbootEdu.naver.controller;


import com.springboot.edu.springbootEdu.naver.dto.ShortUrlResponseDTO;
import com.springboot.edu.springbootEdu.naver.service.ShortUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;

@RestController
@RequestMapping("/short-url")
public class ShortUrlController {

    private final Logger LOGGER = LoggerFactory.getLogger(ShortUrlController.class);

    // ${} 달러와 중괄호 키값을 사용 시 application.properties 에서 값을 가져와 준다
    @Value("${around.hub.short.url.id}")
    private String CLIEND_ID;

    @Value("${around.hub.short.url.secret}")
    private String CLIENT_SECRET;

    ShortUrlService shortUrlService;

    // DI 의존성 주입을 해 줌
    @Autowired
    public ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    // 서비스를 만들 시 어떤 생명주기를 가져야 할 지 고민이 필요 ..... (생성 하고 가져오기 업데이트하고 삭제 하고 ... 생명 주기 지키도록 노력 하기)
    // generateShortUrl
    @PostMapping()
    public ShortUrlResponseDTO generateShortUrl(String originalUrl) {
        LOGGER.info("[generateShortUrl] perform API, CLIENT_ID: {}, CLIENT_SECRET: {} " , CLIEND_ID, CLIENT_SECRET);
        return shortUrlService.generateShortUrl(CLIEND_ID, CLIENT_SECRET, originalUrl);
    }

    // url 값을 가져옴
    @GetMapping
    public ShortUrlResponseDTO getShortUrl(String originalUrl) {
        return shortUrlService.getShortUrl(CLIEND_ID, CLIENT_SECRET, originalUrl);
    }

    @PutMapping()
    public ShortUrlResponseDTO updateShortUrl(String originalUrl) {
        return null;
    }

    @DeleteMapping()
    public ShortUrlResponseDTO deleteShortUrl(String url) {
        return null;
    }

}
