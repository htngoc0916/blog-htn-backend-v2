package com.htn.dto;

import com.htn.constant.StatusConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {
    private int code;
    private String status;
    private Instant timestamp = Instant.now();
    private String message;
    private T data;

    public static <T> ResponseDTO<T> ok(T data) {
        return new ResponseDTO<>(200, StatusConstant.SUCCESS.toString(), Instant.now(),"Response data successfully!", data);
    }

    public static <T> ResponseDTO<T> ok(String message, T data) {
        return new ResponseDTO<>(200, StatusConstant.SUCCESS.toString(), Instant.now(), message, data);
    }

    public static <T> ResponseDTO<T> error(int code, String message, T data) {
        return new ResponseDTO<>(code, StatusConstant.FAIL.toString(),Instant.now(), message, data);
    }
}


