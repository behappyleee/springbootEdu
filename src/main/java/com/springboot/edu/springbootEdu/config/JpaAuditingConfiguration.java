package com.springboot.edu.springbootEdu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Configuration 어노테이션 - 이쪽에 있는 Bean 객체들을 컨테이너에 올려줌  (테스트 할 시 side - effect 를 줄여주기 위하여 어노테이션 사용)
@Configuration  
@EnableJpaAuditing  // EnableJpaAuditin 어느테이션 - JpaAuditing 기능을 사용할 수 있는 어노테이션
public class JpaAuditingConfiguration {


}
