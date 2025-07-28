package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @version 1.0
 * @Author chenglong
 * @className SecurityConfig
 * @Description
 * @Date 2025-07-22
 */
@Configuration
@EnableWebSecurity //是开启SpringSecurity的默认行为
public class SecurityConfig {
    /**
     * 密码明文加密方式配置
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
//        return new CustomMd5PasswordEncoder();
        return new BCryptPasswordEncoder();
    }

}