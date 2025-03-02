package com.flash.regapp.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DataMissMatchException extends RuntimeException{

    public DataMissMatchException(String message) {
        super(message);
    }
}
