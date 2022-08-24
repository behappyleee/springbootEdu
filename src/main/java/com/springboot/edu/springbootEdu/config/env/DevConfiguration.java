package com.springboot.edu.springbootEdu.config.env;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevConfiguration implements EnvConfiguration{

    @Value("# local 환경으로 실행 되었습니다 ! ")
    private String message;

    @Override
    @Bean
    public String getMessage() {
        return message;
    }

}
