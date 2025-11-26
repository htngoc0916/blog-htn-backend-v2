package com.htn.constant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "api.paths")
@Setter
@Getter
@Configuration
public class ApiPathConstant {
    private List<String> publicPatterns;
    private List<String> publicGet;
    private List<String> publicPut;
}
