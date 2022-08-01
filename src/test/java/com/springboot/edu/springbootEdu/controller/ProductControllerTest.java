package com.springboot.edu.springbootEdu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.springboot.edu.springbootEdu.data.dto.ProductDTO;
import com.springboot.edu.springbootEdu.serviceImpl.impl.ProductServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

// WebMvcTest 어노테이션을 붙여준다, - MockMVC 를 Builder 없이 주입 받을 떄 사용
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    
    // given : Mock 객체가 특정 상황에서 해야하는 행위를 정의하는 메서드

    @Autowired
    private MockMvc mockMvc;

    // ProductController 에서 잡고 있는 Bean 객체에 대해 Mock 형태의 객체를 생성 해 줌
    // ProductController 클래스를 보면 기본 생성자로 ProductServiceImpl 을 주입을 받고 있음
    @MockBean
    ProductServiceImpl productService;

    // http://localhost:8080/api/v1/product-api/product/{productId}
    // Test 하는 어노테이션 작성 시 테스트 하는 하나하나의 주체가 됨
    @Test
    @DisplayName("Product 데이터 가져오기 테스트")
    void getProductTest() throws Exception {
        // given : Mock 객체가 특정 상황에서 해야하는 행위를 정의하는 메서드
        // Mockito 라이브러리는 목 객체를 생성하는데 도움을 주는 라이브러리임
        given(productService.getProduct("12315")).willReturn(
                new ProductDTO("15871", "pen", 5000, 2000));

        String productId = "12315";
    
        // andExpenct : 기대하는 값이 나왔는 지 체크해 볼 수 있는 메서드
        // 기본적으로 $. 을 사용하여 존재하는 지 확인
        mockMvc.perform(
                    get("/api/v1/product-api/product/" + productId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").exists())
                .andExpect(jsonPath("$.productName").exists())
                .andExpect(jsonPath("$.productPrice").exists())
                .andExpect(jsonPath("$.productStock").exists())
                .andDo(print());

        // verify : 해당 객체의 메서드가 실행되었는지 체크해 줌
        verify(productService).getProduct("12315");
    }

    // http://localhost:8080/api/v1/product-api/product
    @Test
    @DisplayName("Product 데이터 생성 테스트")
    void createProductTest() throws Exception{
        // Mock 객체의 특정 메서드가 실행이 되는 경우 실제 Return 을 올 수 없기 떄문에 아래와 같이 사항을 만들어 줌
        given(productService.saveProduct("15871", "pen", 5000, 2000)).willReturn(
                new ProductDTO("15871", "pen", 5000, 2000));


        // Post 라는 HTTP 통신을 위하여 DTO 객체를 생성 후 builder 를 통하여 id,name,price,stock 을 builder
        ProductDTO productDTO = ProductDTO.builder().productId("15871").productName("pen")
                .productPrice(5000).productStock(2000).build();

        // Gson 은 JSON 을 조금더 편하게 다루기 위한 라이브러리
        Gson gson = new Gson();
        String content = gson.toJson(productDTO);

        // 만약 Gson 을 사용 안할 시 아래와 처럼 JSON 데이터를 사용이 가능 (ObjetMapper 를 이용)
        // String json = new ObjectMapper().writeValueAsString(productDTO);
        
        // perform 을 사용하고 아까는 get 이였지만 post 메서드이므로 post 를 사용
        mockMvc.perform(
                post("/api/v1/product-api/product")
                        .content(content)
                        // 일반적을 json 타입은 타입을 APPLICATION_JSON 타입을 사용
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").exists())
                .andExpect(jsonPath("$.productName").exists())
                .andExpect(jsonPath("$.productPrice").exists())
                .andExpect(jsonPath("$.productStock").exists())
                .andDo(print());

        // 마지막으로 verify 를 통하여 해당 메서드가 실행 되었는지 Check
        verify(productService).saveProduct("15871", "pen", 5000, 2000);

    }

}
