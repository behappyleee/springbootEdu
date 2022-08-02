package com.springboot.edu.springbootEdu.naver.repository;

import com.springboot.edu.springbootEdu.naver.entity.ShortUrlEntity;

public interface ShortUrlInterface {

    ShortUrlEntity findByUrl(String url);

    ShortUrlEntity findByOrgUrl(String originalUrl);

}
