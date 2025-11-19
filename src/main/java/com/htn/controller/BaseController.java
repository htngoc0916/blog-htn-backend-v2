package com.htn.controller;

import com.htn.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {
    protected <T> ResponseEntity<ResponseDTO<T>> response(T data) {
        return ResponseEntity.ok(ResponseDTO.ok(data));
    }
}
