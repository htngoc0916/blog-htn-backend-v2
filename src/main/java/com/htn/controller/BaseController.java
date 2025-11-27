package com.htn.controller;

import com.htn.dto.ResponseDTO;
import com.htn.i18n.CommonMessages;
import com.htn.i18n.LocalizationService;
import com.htn.i18n.MessageKey;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public abstract class BaseController {
    @Autowired
    protected LocalizationService i18n;

    //response with messages key {}
    protected ResponseEntity<?> response(MessageKey messageKey, Object... args) {
        String msg = i18n.translate(messageKey, args);
        return ResponseEntity.ok(ResponseDTO.ok(msg));
    }
    //response with data and common success message
    protected <T> ResponseEntity<?> response(T data) {
        return ResponseEntity.ok(ResponseDTO.ok(i18n.translate(CommonMessages.COMMON_SUCCESS), data));
    }

    //response with messages key and data
    protected <T> ResponseEntity<?> response(T data, MessageKey messageKey, Object... args) {
        return ResponseEntity.ok(ResponseDTO.ok(i18n.translate(messageKey, args), data));
    }

    //response error with status code and messages key
    protected ResponseEntity<?> error(int status, MessageKey messageKey, Object... args) {
        return ResponseEntity.status(status).body(ResponseDTO.error(status, i18n.translate(messageKey, args), null));
    }
}
