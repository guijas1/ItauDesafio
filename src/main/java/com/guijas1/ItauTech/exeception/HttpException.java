package com.guijas1.ItauTech.exeception;

import org.springframework.http.HttpStatus;

public class HttpException extends RuntimeException {

    private final HttpStatus httpStatus;

    public HttpException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}