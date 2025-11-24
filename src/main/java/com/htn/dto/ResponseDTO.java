package com.htn.dto;

import com.htn.constant.StatusConstant;
import com.htn.i18n.AuthMessages;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {
    private int code;
    private String status;
    private Date date;
    private String message;
    private T data;

    public static <T> ResponseDTO<T> ok(String message) {
        return new ResponseDTO<>(200, StatusConstant.SUCCESS.toString(), new Date(),message, null);
    }

    public static <T> ResponseDTO<T> ok(String message, T data) {
        return new ResponseDTO<>(200, StatusConstant.SUCCESS.toString(), new Date(), message, data);
    }

    public static <T> ResponseDTO<T> error(int code, String message, T data) {
        return new ResponseDTO<>(code, StatusConstant.FAIL.toString(),new Date(), message, data);
    }
}


