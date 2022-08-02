package com.springboot.edu.springbootEdu.naver.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class NaverUriDTO {

    private String message;
    private String code;
    // Result 클래스 안에는 hash / orgUrl / url 이 들어감
    //https://developers.naver.com/docs/utils/shortenurl/#java
    // NaverAPI Reference 를 보게 되면 Result 안에 값이 다 들어감  (XML 형식 에)
    private Result result;

    @Getter
    @Setter
    public static class Result {
        private String hash;
        private String url;
        private String orgUrl;
    }

}
