package com.springboot.edu.springbootEdu.service.impl;

import com.springboot.edu.springbootEdu.dto.MemberDTO;
import com.springboot.edu.springbootEdu.service.RestTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    private final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);

    @Override
    public String getAroundHub() {
        // URI 는 어떤 경로로 요청을 할건지 사용하는 객체
       URI uri = UriComponentsBuilder
               .fromUriString("http://localhost:9090")  // 어떠한 경로인지
               .path("/api/server/around-hub")  // controller 명을 입력
               .encode()    // 인코딩을 해 줌 기본 인코딩은 UTF - 8 로 해 줌
               .build()
               .toUri();

       RestTemplate restTemplate = new RestTemplate();
       ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

       LOGGER.info("getAroundHub Controller");
       LOGGER.info("status Code : {} ", responseEntity.getStatusCode());
       LOGGER.info("Reponse Entity : {} ", responseEntity);
       return responseEntity.getBody();
    }

    @Override
    public String getName() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/name")   // controller url
                .queryParam("name", "Flature")  // query param 값을 어떻게 넣는 지 쿼리 파람 사용 시 key value query param 을 보냄
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {} ", responseEntity.getStatusCode());
        LOGGER.info("body : {} ", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public String getName2() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/path-variable/{name}")   // controller url
                .encode()
                .build()
                .expand("Flature")  // build 후 expand 사용 을 하여 value name 을 넣어 줌
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {} ", responseEntity.getStatusCode());
        LOGGER.info("body : {} ", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public ResponseEntity<MemberDTO> postDto() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/member")   // controller url
                .queryParam("name", "Flature")
                .queryParam("email" , "test@email.com")
                .queryParam("organization", "Around Hub Studio")
                .encode()
                .build()
                .expand("Flature")  // build 후 expand 사용 을 하여 value name 을 넣어 줌
                .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Flature DTO Object");
        memberDTO.setEmail("test123@email.com");
        memberDTO.setOrganization("Around Hub Studio");

        RestTemplate restTemplate = new RestTemplate();

        // RequestEntity 값은 RequestBody로 들어감, uri 로 넘겨줄 때 값은 RequestParam 으로 들어감
        ResponseEntity<MemberDTO> responseEntity = restTemplate.postForEntity(uri, memberDTO, MemberDTO.class);

        LOGGER.info("status code : {} ", responseEntity.getStatusCode());
        LOGGER.info("body : {} ", responseEntity.getBody());

        return responseEntity;
    }

    @Override
    public ResponseEntity<MemberDTO> addHeader() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/member")   // controller url
                .queryParam("name", "Flature")
                .queryParam("email" , "test@email.com")
                .queryParam("organization", "Around Hub Studio")
                .encode()
                .build()
                .expand("Flature")  // build 후 expand 사용 을 하여 value name 을 넣어 줌
                .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Mike");
        memberDTO.setEmail("addHeaderTest@email.com");
        memberDTO.setOrganization("Around Hub Studio");

        RequestEntity<MemberDTO> requestEntity = RequestEntity
                .post(uri)
                .header("around-header", "Around Hub Studio")
                .body(memberDTO);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity = restTemplate.exchange(requestEntity, MemberDTO.class);

        LOGGER.info("status code : {} ", responseEntity.getStatusCode());
        LOGGER.info("body : {} ", responseEntity.getBody());

        return responseEntity;

    }
}
