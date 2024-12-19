package com.javaacademy.shop_chain.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi() {
        Info info = new Info()
                .title("API Магазинов")
                .contact(new Contact().email("ksvatovska@gmail.com")
                        .name("Кристина Сватовская")
                        .url("www.java-academy.ru"))
                .description("API для управления магазинами и их товарами.");
        return new OpenAPI()
                .info(info);
    }
}
