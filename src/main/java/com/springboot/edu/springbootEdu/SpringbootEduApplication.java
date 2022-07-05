package com.springboot.edu.springbootEdu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootEduApplication {

	private static Logger logger = LoggerFactory.getLogger(SpringbootEduApplication.class);

	public static void main(String[] args) {
		logger.debug("Hello World !");
		SpringApplication.run(SpringbootEduApplication.class, args);
	}

}
