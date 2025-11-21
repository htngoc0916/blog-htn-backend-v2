package com.htn.controller;

import com.htn.dto.ResponseDTO;
import com.htn.i18n.MessageKey;
import com.htn.utils.ResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public abstract class BaseController {
    protected final ResponseFactory responseFactory;

    //response with messages key {}
    protected <T> ResponseEntity<ResponseDTO<T>> response(MessageKey messageKey, Object... args) {
        return ResponseEntity.ok(responseFactory.ok(messageKey, args));
    }

    //response with messages key and data
    protected <T> ResponseEntity<ResponseDTO<T>> response(T data, MessageKey messageKey, Object... args) {
        return ResponseEntity.ok(responseFactory.ok(data, messageKey, args));
    }

    //response error with status code and messages key
    protected ResponseEntity<ResponseDTO<Object>> error(int status, MessageKey messageKey, Object... args) {
        return ResponseEntity.status(status).body(responseFactory.error(status, messageKey, args));
    }
}
