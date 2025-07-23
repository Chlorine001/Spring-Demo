package com.example.demo.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * @version 1.0
 * @Author chenglong
 * @className MyBatisPlusConfig
 * @Description 乐观锁和逻辑删除配置--高版本不用配置
 * @Date 2025-07-23
 */

// 扫描我们的 mapper 文件夹
@MapperScan("com.example.demo.mapper")
@EnableTransactionManagement
@Configuration // 配置类
public class MyBatisPlusConfig {

    // 注册乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }


}
