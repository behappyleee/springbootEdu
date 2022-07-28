package com.springboot.edu.springbootEdu.service;

import com.springboot.edu.springbootEdu.dto.MemberDTO;
import org.springframework.http.ResponseEntity;

public interface RestTemplateService {

    public String getAroundHub();

    public String getName();

    public String getName2();

    public ResponseEntity<MemberDTO> pstDto();

    public ResponseEntity<MemberDTO> addHeader();

}
