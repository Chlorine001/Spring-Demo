package com.example.demo.config.jdbc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @Author chenglong
 * @className MyData
 * @Description 配置jdbc数据库链接用户名密码抓取
 * @Date 2025-04-27
 */
@Component
@ToString
@Setter
@Getter
@ConfigurationProperties("jdbc")  //相当于 @ConfigurationProperties(prefix="jdbc")
public class MyData {
    private String username;
    private String password;
}

