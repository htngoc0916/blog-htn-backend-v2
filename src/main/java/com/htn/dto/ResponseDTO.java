package com.htn.dto;

import com.htn.constant.StatusConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {
    private String code;
    private String status;
    private Date date;
    private String message;
    private T data;

    public static <T> ResponseDTO<T> ok(String message) {
        return new ResponseDTO<>(HttpStatus.OK.name(), StatusConstant.SUCCESS.toString(), new Date(),message, null);
    }

    public static <T> ResponseDTO<T> ok(String message, T data) {
        return new ResponseDTO<>(HttpStatus.OK.name(), StatusConstant.SUCCESS.toString(), new Date(), message, data);
    }

    public static <T> ResponseDTO<T> error(String code, String message, T data) {
        return new ResponseDTO<>(code, StatusConstant.FAIL.toString(),new Date(), message, data);
    }
}


