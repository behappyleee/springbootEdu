package com.springboot.edu.springbootEdu.naver.service.impl;

import com.springboot.edu.springbootEdu.naver.dao.ShortUrlDAO;
import com.springboot.edu.springbootEdu.naver.dto.NaverUriDTO;
import com.springboot.edu.springbootEdu.naver.dto.ShortUrlResponseDTO;
import com.springboot.edu.springbootEdu.naver.entity.ShortUrlEntity;
import com.springboot.edu.springbootEdu.naver.repository.ShortUrlRedisRepository;
import com.springboot.edu.springbootEdu.naver.service.ShortUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Optional;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {
    private Logger LOGGER = LoggerFactory.getLogger(ShortUrlServiceImpl.class);

    private final ShortUrlDAO shortUrlDAO;
    private final ShortUrlRedisRepository shortUrlRedisRepository;  // Redis 를 사용하기 위함

    @Autowired
    public ShortUrlServiceImpl(ShortUrlDAO shortUrlDAO, ShortUrlRedisRepository shortUrlRepository) {
        this.shortUrlDAO = shortUrlDAO;
        this.shortUrlRedisRepository = shortUrlRepository;
    }

    @Override
    public ShortUrlResponseDTO getShortUrl(String clientId, String clientSecret, String originalUrl) {
        LOGGER.info("[getShortUrl] data : {} ", originalUrl);

        ShortUrlEntity getShortUrlEntity = shortUrlDAO.getShortUrl(originalUrl);

        // Cache Logic (Cache 에서 값 가져오기) - 값 가져올 시에는 Optional 이용하여 값을 가져옴 (Optional 을 통하여 DTO 값을 가져올 수 있음)
        Optional<ShortUrlResponseDTO> foundResponseDto = shortUrlRedisRepository.findById(originalUrl);

        String orgUrl;
        String shortUrl;

        if(getShortUrlEntity == null) {
            LOGGER.info("[getShourtUrl] No Entity in Database");
            // 값이 없으면 generate 도 해줌
            // 나쁜 코드임 중복되는 코드가 있으므로 따로 하나 메서드를 뺴는게 훨씬 좋음 (메서드 이름이 get 이므로 get 역할만 수행하도록 함)
            ResponseEntity<NaverUriDTO> responseEntity = requestShortUrl(clientId, clientSecret, originalUrl);

            orgUrl = responseEntity.getBody().getResult().getOrgUrl();
            shortUrl = responseEntity.getBody().getResult().getUrl();
        } else {
            orgUrl = getShortUrlEntity.getOrgUrl();
            shortUrl = getShortUrlEntity.getUrl();
        }

        ShortUrlResponseDTO shortUrlResponseDTO = new ShortUrlResponseDTO(orgUrl, shortUrl);

        return shortUrlResponseDTO;
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

        // Cache 에 저장하는 로직
        shortUrlRedisRepository.save(shortUrlResponseDTO);

        LOGGER.info("[generateShourtUrl] Response DTO : {} " , shortUrlResponseDTO.toString());
        return shortUrlResponseDTO;
    }

    @Override
    public ShortUrlResponseDTO updateShortUrl(String shortUrl) {
        return null;
    }

    private ResponseEntity<NaverUriDTO> requestShortUrl(String clientId, String clientSecret, String originalUrl) {
        LOGGER.info("[requestShortUrl] clientId : {} , clientSecret :  {} , original URL : {} " , clientId, clientSecret, originalUrl);
        // URI 를 통하여 외부 uri 와 통신함
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/util/shorturl")
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

    @Override
    public void deleteShortUrl(String url) {
        LOGGER.info("[deleteShortUrl] Request Url : {} " , url );
        if(url.contains("me2.do")) {
            deleteByShortUrl(url);
        } else {
            deleteByOriginalUrl(url);
        }
    }

    public void deleteByShortUrl(String url) {
        LOGGER.info("[deleteByShortUrl] Usl :  {} " , url);
        shortUrlDAO.deleteByShortUrl(url);
    }

    public void deleteByOriginalUrl(String url) {
        LOGGER.info("[deleteByOriginalUrl] Url :  {} " , url);
        shortUrlDAO.deleteByOriginalUrl(url);
    }

}
