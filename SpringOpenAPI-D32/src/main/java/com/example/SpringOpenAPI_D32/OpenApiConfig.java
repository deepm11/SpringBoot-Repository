package com.example.SpringOpenAPI_D32;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Expense Management API",
                version = "1.0",
                description = "APIs for managing expenses and users"
        ),
        servers = {
                @Server(
                        description = "Local Environment",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Production Environment",
                        url = "https://api.example.com"
                )
        }
)
public class OpenApiConfig {


    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-apis")
                .pathsToMatch("/api/**")
                .build();
    }


}
