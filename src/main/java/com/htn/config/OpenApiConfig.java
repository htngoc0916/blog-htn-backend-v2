package com.htn.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import java.util.List;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class OpenApiConfig {
    //info
    @Value("${springdoc.info.title}")
    private String title;
    @Value("${springdoc.info.version}")
    private String version;
    @Value("${springdoc.info.description}")
    private String description;
    //contact
    @Value("${springdoc.info.contact.name}")
    private String name;
    @Value("${springdoc.info.contact.email}")
    private String email;
    //servers
    @Value("${springdoc.server.dev-url}")
    private String devUrl;
    @Value("${springdoc.server.dev-description}")
    private String devDescription;
    @Value("${springdoc.server.prod-url}")
    private String prodUrl;
    @Value("${springdoc.server.prod-description}")
    private String prodDescription;

    @Bean
    public OpenAPI openAPI(){

        Contact contact = new Contact().name(name).email(email);
        Info info = new Info()
                .title(title)
                .version(version)
                .description(description)
                .contact(contact);
        Server devServer = new Server().url(devUrl).description(devDescription);
        Server prodServer = new Server().url(prodUrl).description(prodDescription);
        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer, prodServer));
    }

}
