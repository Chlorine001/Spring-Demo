package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0
 * @Author chenglong
 * @className Food
 * @Description
 * @Date 2025-07-17
 */
@Setter
@Getter
@ApiModel(value = "食物类Model")
public class Food {
    //属性和方法
    @ApiModelProperty(value = "食物ID")
    private String foodId;
    @ApiModelProperty(value = "食物名称")
    private String foodName;

    public Food(String foodId, String foodName) {
        this.foodId = foodId;
        this.foodName = foodName;
    }
}

