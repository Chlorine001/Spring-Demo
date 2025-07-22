package com.example.demo.util;

import lombok.Getter;

/**
 * @version 1.0
 * @Author chenglong
 * @className ResultEnum
 * @Description 枚举返回状态码
 * @Date 2025-07-22
 */
@Getter
public enum ResultCode {

    SUCCESS(200),//成功
    ERROR(400),//失败
    UNAUTHORIZED(401),//未认证（签名错误）
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500), //服务器内部错误
    PARAM_ERROR(400);//错误请求-参数错误

    public final int code;

    ResultCode(int code) {
        this.code = code;
    }

}

