package com.springboot.edu.springbootEdu.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

@SpringBootTest
public class JasyptTest {

    @Test
    void encryptTest() {
        String id = "root";
        String password = "encodingtest";   // password 를 노출을 시키면 안됨 교육용 이기에 해당 처럼 성

        // 암호화 할 시 암호화 할 때 마다 값이 달라짐
        System.out.println("jasyptEncoding id Test : " + jasyptEncoding(id));
        System.out.println("jasyptEncoding Password : " + jasyptEncoding(password));

    }

    public String jasyptEncoding(String value) {
        String key = "around_hub_studio";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }



}
