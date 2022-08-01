package com.springboot.edu.springbootEdu.test_example;

import com.springboot.edu.springbootEdu.testSample.Calculator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void addTest() {
        int actual = calculator.sum(1 ,2);
        int expected = 3;

        // actual (실제로 나오는 값), expected (기대하는 값)
        // assertThat 구문을 사용하여 보기 좋은 코드를 만들어 냄
       assertThat(actual, is(expected));
    }

    @Test
    public void multiple() {
        int actual = calculator.multiple(1, 2); // 실제 값
        int expected = 2;   // 기대 값

        assertThat(actual, is(expected));
    }



}

