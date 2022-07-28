package com.springboot.edu.springbootEdu.common.exception;

import com.springboot.edu.springbootEdu.common.Constants;
import org.springframework.http.HttpStatus;

public class AroundHubException extends Exception {
    private static final long serialVersionUID = 4663380430591151694L;

    private Constants.ExceptionClass exceptionClass;
    private HttpStatus httpStatus;

    // AroundHubException 생성자
    // super 를 이용하여 부모에게 메세지 전달 부모 클래스에 message 가 있음
    public AroundHubException (Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message) {
        super(exceptionClass.toString() + message);
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    public Constants.ExceptionClass getExceptionClass() {
        return exceptionClass;
    }

    public int getHttpStatusCode() {
        return httpStatus.value();
    }

    public String getHttpStatusType() {
        return httpStatus.getReasonPhrase();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
