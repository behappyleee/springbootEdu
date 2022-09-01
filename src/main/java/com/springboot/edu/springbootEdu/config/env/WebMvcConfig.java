package com.springboot.edu.springbootEdu.config.env;

import com.springboot.edu.springbootEdu.interceptor.HttpInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    // WebMvcConfiguere 는 메서드가 default 로 구현 되어 있어 필요한 메서드만 가져오기

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/hello");







    }

}
