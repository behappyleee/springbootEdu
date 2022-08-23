package com.springboot.edu.springbootEdu;

import com.springboot.edu.springbootEdu.config.ProfileManager;
import com.springboot.edu.springbootEdu.config.env.EnvConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing	// Jpa 관련 Auditing 기능들을 사용할 수 있게 해주는 어노테이션
public class SpringbootEduApplication {

	private static Logger logger = LoggerFactory.getLogger(SpringbootEduApplication.class);

	// 각 환경에 맞게 Config (env / local)
	@Autowired
	public SpringbootEduApplication(EnvConfiguration envConfiguration, ProfileManager profileManager) {
		logger.info(envConfiguration.getMessage());

	}





	public static void main(String[] args) {
		SpringApplication.run(SpringbootEduApplication.class, args);
	}

}
