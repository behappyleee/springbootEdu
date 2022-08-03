package com.springboot.edu.springbootEdu.naver.dao;

import com.springboot.edu.springbootEdu.naver.entity.ShortUrlEntity;

public interface ShortUrlDAO {

    ShortUrlEntity saveShortUrl(ShortUrlEntity shortUrl);

    ShortUrlEntity getShortUrl(String originalUrl);

}
