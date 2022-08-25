package com.springboot.edu.springbootEdu.config.env;


import com.springboot.edu.springbootEdu.SpringbootEduApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevConfiguration implements EnvConfiguration{

    private static Logger logger = LoggerFactory.getLogger(DevConfiguration.class);

    @Value("${around.hub.loading.message}")
    private String message;

    @Override
    @Bean
    public String getMessage() {
        logger.info("[getMessage] devConfigurariotn 입니다.]");
        return message;
    }

}
