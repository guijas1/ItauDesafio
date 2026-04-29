package com.guijas1.ItauTech.exeception;

import org.springframework.http.HttpStatus;

public class MinorSecondsExeception extends RuntimeException {

    public MinorSecondsExeception(String message) {
        super(message);

    }
}
