package com.htn.exception;

import com.htn.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    //Custom global exception handler
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<?> handleCustomException(GlobalException exp, WebRequest request){
        log.error("handleCustomException: {}", exp.getMessage());
        ResponseDTO<?> responseDTO = ResponseDTO.error(exp.getCode().value()
                                                    ,exp.getMessage(),
                                                    request.getDescription(false));
        return ResponseEntity.status(exp.getCode()).body(responseDTO);
    }

    //Global exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception exp, WebRequest request){
        log.error("handleGlobalException: {}", exp.getMessage());
        ResponseDTO<?> responseDTO = ResponseDTO.error(HttpStatus.INTERNAL_SERVER_ERROR.value()
                                                    ,exp.getMessage(),
                                                    request.getDescription(false));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
    }

    //loi  Access Denied
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException exp, WebRequest request){
        log.error("handleAccessDeniedException: {}", exp.getMessage());
        ResponseDTO<?> responseDTO = ResponseDTO.error(HttpStatus.UNAUTHORIZED.value()
                ,exp.getMessage(),
                request.getDescription(false));
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDTO);
    }

    // Loi validation cua @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exp,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        for (FieldError error : exp.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        log.error("handleMethodArgumentNotValid: {}", errors);

        ResponseDTO<?> responseDTO = ResponseDTO.error(
                status.value(),
                exp.getBody().getDetail(),
                errors
        );

        return ResponseEntity.status(status).body(responseDTO);
    }
}
