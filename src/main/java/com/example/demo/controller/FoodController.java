package com.example.demo.controller;

import com.example.demo.entity.Food;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @Author chenglong
 * @className FoodController
 * @Description
 * @Date 2025-07-17
 */
@RestController
@Api(value = "食物Controller", tags = {"获取食物相关接口"})
@RequestMapping(value = "/food")
public class FoodController {
    @ApiOperation(value = "获取食物类")
    @GetMapping("/getFood")
    public List<Food> getFood() {
        // 返回食物列表
        return Arrays.asList(new Food("1", "苹果"), new Food("2", "香蕉"));
    }
}