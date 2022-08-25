package com.springboot.edu.springbootEdu.config.env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local")
@Configuration
public class LocalConfiguration implements EnvConfiguration{

    private static Logger logger = LoggerFactory.getLogger(LocalConfiguration.class);

    @Value("${around.hub.loading.message}")
    private String message;

    @Override
    @Bean
    public String getMessage() {
        logger.info("[ local configuration 입니다 !!! ]");
        return message;
    }

}
