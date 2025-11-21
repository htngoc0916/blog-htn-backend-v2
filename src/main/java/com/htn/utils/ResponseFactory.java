package com.htn.utils;

import com.htn.constant.StatusConstant;
import com.htn.dto.ResponseDTO;
import com.htn.i18n.LocalizationService;
import com.htn.i18n.MessageKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class ResponseFactory {
    private final LocalizationService localizationService;

    public <T> ResponseDTO<T> ok(MessageKey key, Object... args) {
        String msg = localizationService.translate(key, args);

        return ResponseDTO.<T>builder()
                .code(200)
                .status(StatusConstant.SUCCESS.toString())
                .date(Instant.now())
                .message(msg)
                .data(null)
                .build();
    }

    public <T> ResponseDTO<T> ok(T data, MessageKey key, Object... args) {
        String msg = localizationService.translate(key, args);

        return ResponseDTO.<T>builder()
                .code(200)
                .status(StatusConstant.SUCCESS.toString())
                .date(Instant.now())
                .message(msg)
                .data(data)
                .build();
    }

    public <T> ResponseDTO<T> error(int code, MessageKey key, Object... args) {
        String msg = localizationService.translate(key, args);

        return ResponseDTO.<T>builder()
                .code(code)
                .status(StatusConstant.SUCCESS.toString())
                .date(Instant.now())
                .message(msg)
                .data(null)
                .build();
    }

}
