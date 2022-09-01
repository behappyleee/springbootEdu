package com.springboot.edu.springbootEdu.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HttpInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(HttpInterceptor.class);

    // preHandle - Controller 가기 전에 postHandle 메서드 실행
    // postHandle - 로직 실행 후 postHandle 메서드 실행
    //

    // Object handler 에 데이터가 담김
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws  Exception {
        logger.debug("[preHandle] preHandle is performed");
        logger.debug("[preHandle] preHandle request : {} ", request);
        logger.debug("[preHandle] preHandle request pathInfo : {} ", request.getPathInfo());
        logger.debug("[preHandle] preHandle request header name : {} " , request.getHeaderNames());
        logger.debug("[preHandle] preHandle request URL : {} ", request.getRequestURL());
        logger.debug("[preHandle] preHandle request URi : {} ", request.getRequestURI());
        logger.debug("[preHandle] preHandle request sessionId : {} ", request.getRequestedSessionId());

        // HttpServletRquestWrapper 구현 하여 Body 값 확인 할 수 있게 코드 추가
        // request.getInputStream();    // getInputStream 을 사용 시 한번만 확인이 가능함
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception{
        logger.info("[postHandle] postHandle is performed");
        logger.info("[postHandle] postHandle request : {} " , request);
        logger.info("[postHandle] postHandle reqsponse : {} " , response);
        logger.info("[postHandle] postHandle reqsponse HeaderNames: {} " , response.getHeaderNames());
    }





}
