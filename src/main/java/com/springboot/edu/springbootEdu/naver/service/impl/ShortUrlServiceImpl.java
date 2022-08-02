package com.springboot.edu.springbootEdu.naver.service.impl;

import com.springboot.edu.springbootEdu.naver.dto.NaverUriDTO;
import com.springboot.edu.springbootEdu.naver.dto.ShortUrlResponseDTO;
import com.springboot.edu.springbootEdu.naver.entity.ShortUrlEntity;
import com.springboot.edu.springbootEdu.naver.service.ShortUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {
    private Logger LOGGER = LoggerFactory.getLogger(ShortUrlServiceImpl.class);

    @Override
    public ShortUrlResponseDTO getShortUrl(String clientId, String clientSeceret, String originalUrl) {
        return null;
    }

    // ReturnType 이 DTO
    @Override
    public ShortUrlResponseDTO generateShortUrl(String clientId, String clientSecret, String originalUrl) {

        // 로거 출력시 Thread 번호 까지 나오므로 잘 찍기 !! Log
        LOGGER.info("[generateShortUrl] request DATA : {} " , originalUrl);

        ResponseEntity<NaverUriDTO> responseEntity = requestShortUrl(clientId, clientSecret, originalUrl);

        String orgUrl = responseEntity.getBody().getResult().getOrgUrl();
        String shortUrl = responseEntity.getBody().getResult().getUrl();
        String hash = responseEntity.getBody().getResult().getHash();

        ShortUrlEntity shortUrlEntity = new ShortUrlEntity();
        shortUrlEntity.setOrgUrl(orgUrl);
        shortUrlEntity.setUrl(shortUrl);
        shortUrlEntity.setHash(hash);

        shortUrlDAO.saveShortUrl(shortUrlEntity);


        ShortUrlResponseDTO shortUrlResponseDTO = new ShortUrlResponseDTO(orgUrl, shortUrl);

        LOGGER.info("[generateShourtUrl] Response DTO : {} " , shortUrlResponseDTO.toString());

        return shortUrlResponseDTO;
    }

    @Override
    public ShortUrlResponseDTO updateShortUrl(String shortUrl) {
        return null;
    }

    @Override
    public ShortUrlResponseDTO deleteByOriginalUrl(String originalUrl) {
        return null;
    }

    private ResponseEntity<NaverUriDTO> requestShortUrl(String clientId, String clientSecret, String originalUrl) {
        LOGGER.info("[requestShortUrl] clientId, clientSecret, original URL : {} " , originalUrl);
        // URI 를 통하여 외부 uri 와 통신함
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/util/shortUrl")
                .queryParam("url", originalUrl)
                .encode()
                .build()
                .toUri();

        LOGGER.info("[requestShortUrl] set HTTP Header");
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Naver-Client-Id" , clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);

        HttpEntity<String> entity = new HttpEntity<>("", headers);
        RestTemplate restTemplate = new RestTemplate();

        LOGGER.info("[requestShortUrl] request by restTemplate");

        // exchange 메서드를 통하여 통신을 함 return 은 NaverUriDTO 형식으로 받는것으로 설정
        ResponseEntity<NaverUriDTO> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, NaverUriDTO.class);
        LOGGER.info("[requestShortUrl] request has been successfully complete RESPONSE Entity : {} " , responseEntity);

        return responseEntity;
    }


}
