package com.springboot.edu.springbootEdu.naver.dao.impl;


import com.springboot.edu.springbootEdu.naver.dao.ShortUrlDAO;
import com.springboot.edu.springbootEdu.naver.entity.ShortUrlEntity;
import com.springboot.edu.springbootEdu.naver.repository.ShortUrlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShortUrlDAOImpl implements ShortUrlDAO {
    Logger LOGGER = LoggerFactory.getLogger(ShortUrlDAOImpl.class);
    private final ShortUrlRepository shortUrlRepository;

    @Autowired
    public ShortUrlDAOImpl(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    @Override
    public ShortUrlEntity saveShortUrl(ShortUrlEntity shortUrl) {
        ShortUrlEntity foundShortUrl = shortUrlRepository.save(shortUrl);
        return foundShortUrl;
    }

    @Override
    public ShortUrlEntity getShortUrl(String originalUrl) {
        ShortUrlEntity foundShortUrl = shortUrlRepository.findByOrgUrl(originalUrl);
        return foundShortUrl;
    }

    @Override
    public ShortUrlEntity getOriginalUrl(String shortUrl) {
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.findByUrl(shortUrl);
        return foundShortUrlEntity;
    }

    @Override
    public ShortUrlEntity updateShortUrl(ShortUrlEntity newShortUrlEntity) {
        // 새로운 shortUrlEntity 를 받아 올 시 새로운 shortUrlEntity 를 저장을 함
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.findByOrgUrl(newShortUrlEntity.getOrgUrl());
        foundShortUrlEntity.setUrl(newShortUrlEntity.getUrl());
        ShortUrlEntity saveShortUrlEntity = shortUrlRepository.save(foundShortUrlEntity);
        return saveShortUrlEntity;
    }

    @Override
    public void deleteByShortUrl(String shortUrl) {
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.findByUrl(shortUrl);
        LOGGER.info("[deleteByShortUrl ServiceImpl] shortUrl :  {} " , shortUrl);
        shortUrlRepository.delete(foundShortUrlEntity);
    }

    @Override
    public void deleteByOriginalUrl(String originalUrl) {
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.findByOrgUrl(originalUrl);
        LOGGER.info("[deleteByOriginalUrl ServiceImpl] shortUrl :  {} " , originalUrl);
        shortUrlRepository.delete(foundShortUrlEntity);
    }

}
