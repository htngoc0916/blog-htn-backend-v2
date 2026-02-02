package com.htn.exception;

import com.htn.constant.ErrorCode;
import lombok.Getter;

import java.io.Serial;

@Getter
public class UnauthorizedException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private final ErrorCode errorCode;
    private final String message;

    public UnauthorizedException(ErrorCode errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
    }

    public UnauthorizedException(String message){
        this.errorCode = ErrorCode.ACCOUNT_UNAUTHORIZED;
        this.message = message;
    }

}
