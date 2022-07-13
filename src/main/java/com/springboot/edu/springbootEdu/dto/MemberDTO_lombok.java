package com.springboot.edu.springbootEdu.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


// Lombok 을 사용시 많은 코드양을 줄일 수 있음
@Setter
@Getter
@ToString
public class MemberDTO_lombok {
    // 필드 선언
    private String name;
    private String email;
    private String organization;

    public static void main(String[] args) {
        MemberDTO_lombok test = new MemberDTO_lombok();
        // toString() Lombok 으로 annotation 으로 override 된 메서드가 실행이 됨
        System.out.println(test.toString());
    }
}
