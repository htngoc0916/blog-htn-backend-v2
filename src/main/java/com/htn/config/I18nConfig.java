package com.htn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Configuration
public class I18nConfig {
    @Value("${i18n.default-language}")
    private String defaultLanguage;

    @Value("${i18n.supported-languages}")
    private String supportedLanguages;

    @Value("${i18n.base-name}")
    private String baseName;

    @Value("${i18n.message-encoding}")
    private String messageEncoding;

    @Value("${i18n.cache-seconds}")
    private int cacheSeconds;


    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver resolver = new AcceptHeaderLocaleResolver();
        // Set default locale
        resolver.setDefaultLocale(Locale.forLanguageTag(defaultLanguage));

        // Parse supported-languages: "en,vi,ko"
        List<Locale> localeList = Arrays.stream(supportedLanguages.split(","))
                .map(String::trim)
                .map(Locale::forLanguageTag)
                .toList();
        resolver.setSupportedLocales(localeList);

        return resolver;
    }

    @Bean
    public MessageSource messageSource() {
        // use ReloadableResourceBundleMessageSource so we can change messages in dev without restart
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(baseName);
        messageSource.setDefaultEncoding(messageEncoding);
        messageSource.setCacheSeconds(cacheSeconds);
        // do not fall back to system locale to keep deterministic behavior
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }

    @Bean
    public MessageSourceAccessor messageSourceAccessor(MessageSource messageSource) {
        return new MessageSourceAccessor(messageSource);
    }
}
