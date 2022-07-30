package com.springboot.edu.springbootEdu.test;

import org.junit.jupiter.api.*;


// Test 어노테이션을 붙인 메서드가 있어야 실행이 가능 !!
public class TestLifeCycle {

    // Test 를 하기 위하여서는 위 Java 에서 경로를 똑같이 맞추어 주어야 함
    // Ex Product 를 테스트 하기 위하여서는 ProductController package controller 를 똑같이 맞추어 주어야 함 (이름을 ProductControllerTest 를 맞추어 주어야함)

    // BeforeAll 은 모든 메서드가 시작 되기 전 한번 모두 실행되는 어노테이션
    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll Annotation!");
        System.out.println();
    }

    // AfterAll 은 모든 메서드가 실행 된 후 한 번 모두 실행 되는 어노테이션
    @AfterAll
    static void afterAll() {
        System.out.println("afterAll Annotation ! ");
        System.out.println();
    }

    // beforeEach 어노테이션은 각 테스트 메서드가 실행되기 전 실행시키는 어노테이션
    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach Annotation !");
        System.out.println();
    }

    // afterEach 는 각 테스트 메서드가 실행된 후 실행하는 어노테이션
    @AfterEach
    void afterEach() {
        System.out.println("afterEach Annotation ! ");
        System.out.println();
    }

    @Test
    void test1() {
        System.out.println("test1 시작 !!");
        System.out.println();
    }

    @Test
    @DisplayName("Test Case 2 !!")
    void test2() {
        System.out.println("test2 Case 시작 !!");
        System.out.println();
    }

    @Test
    @Disabled   // Disabled Annotation : 테스트를 실행하지 않게 실행 하는 어노테이션
    void test3() {
        System.out.println("Test Case 3 시작!!");
        System.out.println();
    }


}
