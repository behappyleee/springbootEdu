package com.springboot.edu.springbootEdu.naver.dao.impl;


import com.springboot.edu.springbootEdu.naver.dao.ShortUrlDAO;
import com.springboot.edu.springbootEdu.naver.entity.ShortUrlEntity;
import com.springboot.edu.springbootEdu.naver.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShortUrlDAOImpl implements ShortUrlDAO {

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
}
