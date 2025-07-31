package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @version 2.0
 * @Author chenglong
 * @className HelloTestController
 * @Description 一个简单api接口
 * @Date 2025-07-31
 */
@RequestMapping("/test/v2")
@RestController
@Tag(name = "测试接口类")
@Slf4j
public class HelloTestController {

    @Operation(tags = "测试hello")
    @PostMapping("/hello")
    public String hello(HttpServletRequest request){
        String authorization = request.getHeader("Authorization");
        log.info(authorization);
        return "hello";
    }

    @Operation(tags = "测试接口")
    @GetMapping("/hello")
//    @PreAuthorize("hasAnyAuthority('admin','test','system:dept:list')")
//    @PreAuthorize("hasRole('system:dept:list')")
//    @PreAuthorize("hasAnyRole('admin','system:dept:list')")
    public String hello(){
        return "hello";
    }

}
