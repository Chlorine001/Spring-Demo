package com.example.demo.controller;

import com.example.demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author chenglong
 * @className UserController
 * @Description
 * @Date 2025-07-17
 */
@RestController
@Api(tags = "用户管理", description = "提供用户信息的接口")
public class UserController {
    @ApiOperation(value = "对接口功能的说明", notes = "根据用户传入的信息返回用户对象")
    @GetMapping("/user")
    public User sayUser(User user) {
        return user;
    }
}