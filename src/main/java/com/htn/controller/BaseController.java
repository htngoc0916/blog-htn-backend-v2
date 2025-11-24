package com.htn.controller;

import com.htn.i18n.MessageKey;
import com.htn.utils.ResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public abstract class BaseController {
    @Autowired
    protected ResponseFactory responseFactory;

    //response with messages key {}
    protected ResponseEntity<?> response(MessageKey messageKey, Object... args) {
        return ResponseEntity.ok(responseFactory.ok(messageKey, args));
    }

    //response with messages key and data
    protected <T> ResponseEntity<?> response(T data, MessageKey messageKey, Object... args) {
        return ResponseEntity.ok(responseFactory.ok(data, messageKey, args));
    }

    //response error with status code and messages key
    protected ResponseEntity<?> error(int status, MessageKey messageKey, Object... args) {
        return ResponseEntity.status(status).body(responseFactory.error(status, messageKey, args));
    }
}
