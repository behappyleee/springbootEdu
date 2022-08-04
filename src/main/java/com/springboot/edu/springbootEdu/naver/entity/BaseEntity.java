package com.springboot.edu.springbootEdu.naver.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)  // Listener 어노테이션을 사용할시 밑에 LastModifiedDate 어노테이션 사용이 가능
public class BaseEntity {
    // ShourtUrlEntity 에서 상속을 하므로 밑에 두 컬러믈 ShortUrlEntity 에 포함을 시켜 줌
    // CreatedDate / LastModifiedDate 어노테이션을 통하여 값이 자동으로 업데이트가 됨

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}
