package com.example.demo.util;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author chenglong
 * @className Result
 * @Description 统一API响应结果封装
 * @Date 2025-07-22
 */

@Setter
@Getter
public class Result<T> implements Serializable {
    @Getter
    private int code;
    private String message;
    private T data;
    private String traceId;

    public Result() {
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result:{" +
                "code:" + code +
                ", message:'" + message + '\'' +
                ", data:" + data +
                '}';
    }

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code;
        return this;
    }
    public Result setData(T data) {
        this.data = data;
        return this;
    }
    public Result setMessage(String message) {
        this.message = message;
        return this;
    }
}
