package com.htn.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class NotFoundException extends GlobalException {
    @Serial
    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND,message);
    }
}
