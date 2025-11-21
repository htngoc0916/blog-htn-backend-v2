package com.htn.i18n;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Wrapper tiện lợi cho MessageSource / MessageSourceAccessor.
 * - Hỗ trợ typed MessageKey (enum)
 * - Vẫn hỗ trợ string key (backward compatible)
 * - Hỗ trợ default message và explicit Locale
 */
@Service
@RequiredArgsConstructor
public class LocalizationService {

    private final MessageSourceAccessor accessor;
    private final MessageSource messageSource;

    /**
     * Dịch key (current locale)
     */
    public String translate(String key, Object... args) {
        return accessor.getMessage(key, args, LocaleContextHolder.getLocale());
    }

    /**
     * Dịch MessageKey (enum)
     */
    public String translate(MessageKey key, Object... args) {
        return translate(key.getKey(), args);
    }

    /**
     * Dịch với default message nếu key không tồn tại
     */
    public String translateOrDefault(String key, String defaultMessage, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(key, args, defaultMessage, locale);
    }

    public String translateOrDefault(MessageKey key, String defaultMessage, Object... args) {
        return translateOrDefault(key.getKey(), defaultMessage, args);
    }

    /**
     * Dịch với explicit locale
     */
    public String translate(String key, Locale locale, Object... args) {
        return messageSource.getMessage(key, args, key, locale);
    }

    public boolean exists(String key) {
        // nếu ko tồn tại sẽ ném NoSuchMessageException -> catch và trả false
        try {
            messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}