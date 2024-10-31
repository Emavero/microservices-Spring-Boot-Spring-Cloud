package com.example.produit_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI produitServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Produit Service API")
                        .description("API pour la gestion des produits")
                        .version("v1.0")
                        .contact(new Contact().name("Support API").email("preiraclement79@gmail.com"))
                );
    }
}
