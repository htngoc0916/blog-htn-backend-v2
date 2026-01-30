package com.htn.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    ACCOUNT_LOCKED(HttpStatus.FORBIDDEN, "ACCOUNT_LOCKED"),
    ACCOUNT_EMAIL_NOT_VERIFIED(HttpStatus.FORBIDDEN, "ACCOUNT_NOT_VERIFIED");

    private final HttpStatus code;
    private final String name;
}
