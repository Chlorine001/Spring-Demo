package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @Author chenglong
 * @className User
 * @Description
 * @Date 2025-07-17
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户实体")
public class User {
    @ApiModelProperty(value = "姓名", example = "张飞")
    private String username;
    @ApiModelProperty(value = "密码", example = "123", required = true)
    private Integer password;
}
