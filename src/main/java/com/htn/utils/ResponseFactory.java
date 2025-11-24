package com.htn.utils;

import com.htn.dto.ResponseDTO;
import com.htn.i18n.LocalizationService;
import com.htn.i18n.MessageKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ResponseFactory {
    private final LocalizationService localizationService;

    public <T> ResponseDTO<T> ok(MessageKey key, Object... args) {
        String msg = localizationService.translate(key, args);
        return ResponseDTO.ok(msg);
    }

    public <T> ResponseDTO<T> ok(T data, MessageKey key, Object... args) {
        String msg = localizationService.translate(key, args);
        return ResponseDTO.ok(msg, data);
    }

    public <T> ResponseDTO<T> error(int code, MessageKey key, Object... args) {
        String msg = localizationService.translate(key, args);
        return ResponseDTO.error(code, msg, null);
    }

}
