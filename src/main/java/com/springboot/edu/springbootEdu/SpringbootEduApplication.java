package com.springboot.edu.springbootEdu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing	// Jpa 관련 Auditing 기능들을 사용할 수 있게 해주는 어노테이션
public class SpringbootEduApplication {

	private static Logger logger = LoggerFactory.getLogger(SpringbootEduApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEduApplication.class, args);
	}

}
