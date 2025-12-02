package com.htn.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class UnauthorizedException extends GlobalException {
    @Serial
    private static final long serialVersionUID = 1L;

    public UnauthorizedException(String message){
        super(HttpStatus.UNAUTHORIZED, message);
    }
}
