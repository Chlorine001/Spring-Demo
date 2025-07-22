package com.example.demo.util;

/**
 * @version 1.0
 * @Author chenglong
 * @className ResultUtil
 * @Description
 * @Date 2025-07-22
 */
public class ResultUtil {

    public static <T> Result<T>  defineSuccess(ResultCode code, T data) {
        Result result = new Result<>();
        return result.setCode(code).setData(data);
    }

    public static <T> Result<T> success(T data) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS).setData(data);
        return result;
    }

    public static <T> Result<T> fail(String message) {
        Result result = new Result();
        result.setCode(ResultCode.FAIL).setMessage(message);
        return result;
    }

    public static <T> Result<T> defineFail(ResultCode code, String message){
        Result result = new Result();
        result.setCode(code).setMessage(message);
        return result;
    }

    public static <T> Result<T> define(ResultCode code, String message, T data){
        Result result = new Result();
        result.setCode(code).setMessage(message).setData(data);
        return result;
    }
}
