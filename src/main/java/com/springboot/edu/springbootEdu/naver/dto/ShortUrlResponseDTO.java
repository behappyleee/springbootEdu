package com.springboot.edu.springbootEdu.naver.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ShortUrlResponseDTO implements Serializable {

    private static final long serialVersionUID = 2232321321312323L;

    @Id
    private String orgUrl;

    private String shortUrl;

}
