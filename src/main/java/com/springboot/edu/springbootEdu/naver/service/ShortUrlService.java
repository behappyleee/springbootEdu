package com.springboot.edu.springbootEdu.naver.service;

import com.springboot.edu.springbootEdu.naver.dto.ShortUrlResponseDTO;

public interface ShortUrlService {

    ShortUrlResponseDTO getShortUrl(String clientId, String clientSeceret, String originalUrl);

    ShortUrlResponseDTO generateShortUrl(String clientId, String clientSecret, String originalUrl);

    ShortUrlResponseDTO updateShortUrl(String shortUrl);

    ShortUrlResponseDTO deleteByOriginalUrl(String originalUrl);
}
