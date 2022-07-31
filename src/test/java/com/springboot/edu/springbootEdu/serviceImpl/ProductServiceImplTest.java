package com.springboot.edu.springbootEdu.serviceImpl;

import com.springboot.edu.springbootEdu.data.Entity.ProductEntity;
import com.springboot.edu.springbootEdu.data.dto.ProductDTO;
import com.springboot.edu.springbootEdu.data.handler.impl.ProductDataHandlerImpl;
import com.springboot.edu.springbootEdu.serviceImpl.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@Import({ProductDataHandlerImpl.class, ProductServiceImpl.class})
public class ProductServiceImplTest {

    // 기존에 ProductServiceImpl 을 확인 할 시
    // 기존 생성자에 ProductDataHandler 를 주입 받아 생성이 됨

    // MockBean 을 통하여 기존에 ProductDataHandler 를 주입 받음
    @MockBean
    ProductDataHandlerImpl productDataHandler;

    // 테스트 받아야 할 객체를 하나를 주입 받음
    @Autowired
    ProductServiceImpl productService;

    //
    @Test
    public void getProductTest() {

        // given
        Mockito.when(productDataHandler.getProductEntity("123"))
                .thenReturn(new ProductEntity("123", "pen", 2000, 3000));

        // getProduct 할 시 DTO 로 변환 되기에 ProductDTO 타입으로 받음
        ProductDTO productDTO = productService.getProduct("123");

        Assertions.assertEquals(productDTO.getProductId(), "123");
        Assertions.assertEquals(productDTO.getProductName(), "pen");
        Assertions.assertEquals(productDTO.getProductPrice(), 2000);
        Assertions.assertEquals(productDTO.getProductStock(), 3000);

        verify(productDataHandler).getProductEntity("123");

    }

    @Test
    public void saveProductTest() {
        // given
        Mockito.when(productDataHandler.saveProductEntity("123", "pen", 2000, 3000 ))
                .thenReturn(new ProductEntity("123", "pen", 2000, 3000));

        ProductDTO productDTO = productService.saveProduct("123", "pen", 2000, 3000);

        Assertions.assertEquals(productDTO.getProductId(), "123");
        Assertions.assertEquals(productDTO.getProductName(), "pen");
        Assertions.assertEquals(productDTO.getProductPrice(), 2000);
        Assertions.assertEquals(productDTO.getProductStock(), 3000);
    
        // verify 를 이용하여 정상적으로 실행이 되었는지 체크
        verify(productDataHandler).saveProductEntity("123","pen", 2000, 3000);

    }



}
