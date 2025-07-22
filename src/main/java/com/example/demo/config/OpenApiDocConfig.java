package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @Author chenglong
 * @className OpenApiDocConfig
 * @Description
 * @Date 2025-07-22
 */
@Configuration
public class OpenApiDocConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API 文档").version("1.0"));
    }
}