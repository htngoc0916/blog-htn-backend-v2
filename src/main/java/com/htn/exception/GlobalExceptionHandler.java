package com.htn.exception;

import com.htn.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    //Custom global exception handler
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<?> handleCustomException(GlobalException exp, WebRequest request){
        log.error(exp.getMessage());
        ResponseDTO<?> responseDTO = ResponseDTO.ok(exp.getCode().value()
                ,exp.getMessage(),
                request.getDescription(false));
        return ResponseEntity.status(exp.getCode()).body(responseDTO);
    }

    //Global exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception exp, WebRequest request){
        log.error(exp.getMessage());
        ResponseDTO<?> responseDTO = ResponseDTO.error(HttpStatus.INTERNAL_SERVER_ERROR.value()
        ,exp.getMessage(),
        request.getDescription(false));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
    }
}
