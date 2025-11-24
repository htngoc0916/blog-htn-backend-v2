package com.htn.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GlobalException extends RuntimeException {
    private final HttpStatus code;
    private final String message;

    public GlobalException(String message) {
        super(message);
        this.code = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message = message;
    }

    public GlobalException(HttpStatus code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
