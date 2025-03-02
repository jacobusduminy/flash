package com.flash.regapp.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class LookupDataException extends RuntimeException{

    public LookupDataException(String message) {
        super(message);
    }

    public LookupDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
