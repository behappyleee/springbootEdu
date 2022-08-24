package com.springboot.edu.springbootEdu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class ProfileManager {

    private final Logger logger = LoggerFactory.getLogger(ProfileManager.class);
    private final Environment environment;

    @Autowired
    public ProfileManager(Environment environment) {
        this.environment = environment;
    }

    public void printActiveProfiles() {
        logger.info("[ProfileActiveProfiles] active profiles size : {} " , environment.getActiveProfiles().length);
        for(String profile : environment.getActiveProfiles()) {
            logger.info("[printActiveProfiles] : {} " , profile);
        }
    }


}
