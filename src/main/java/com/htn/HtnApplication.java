package com.htn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HtnApplication {

    public static void main(String[] args) {
        SpringApplication.run(HtnApplication.class, args);
    }

}
