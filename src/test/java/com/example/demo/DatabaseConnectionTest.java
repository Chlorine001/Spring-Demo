package com.example.demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Author chenglong
 * @className DatabaseConnectionTest
 * @Description 测试数据库是否链接成功
 * @Date 2025-04-30
 */
@SpringBootTest
public class DatabaseConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void testConnection() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("数据库连接成功！");
            System.out.println("数据库 URL: " + connection.getMetaData().getURL());
            System.out.println("数据库用户: " + connection.getMetaData().getUserName());
        }
    }
}