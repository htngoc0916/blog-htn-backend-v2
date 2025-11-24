package com.htn.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UnauthorizedException extends GlobalException {

    public UnauthorizedException(String message){
        super(HttpStatus.UNAUTHORIZED, message);
    }
}
