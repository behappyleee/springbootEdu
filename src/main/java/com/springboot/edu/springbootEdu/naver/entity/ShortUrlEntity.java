package com.springboot.edu.springbootEdu.naver.entity;

import lombok.*;


import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "short_url")
public class ShortUrlEntity extends BaseEntity{
    
    // 상속 받은 BaseEntity 에서 createdAt / updatedAt 두 컬럼을 추가하여 준다


    // Table 을 읽어서 Index 번호를 가져옴
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // GeneartionType.IDENTITY 를 잡아서 인덱스 번호를 가져옴

    @Column(nullable = false, unique = true)
    private String hash;

    @Column(nullable = false, unique = true)
    private String url;

    @Column(nullable = false, unique = true)
    private String orgUrl;

}
