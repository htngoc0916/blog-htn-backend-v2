package com.htn.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AccessDeniedException extends GlobalException {

    public AccessDeniedException(String message){
        super(HttpStatus.FORBIDDEN, message);
    }
}
