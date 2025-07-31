package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author chenglong
 * @className APIDemoTestController
 * @Description 一个简单api接口
 * @Date 2025-07-17
 */
@RequestMapping("/test/v1")
@RestController
public class APIDemoTestController {
    @GetMapping("/get")
    public String get() {
        return "get";
    }

    @PostMapping("/post")
    public String post() {
        return "post";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
