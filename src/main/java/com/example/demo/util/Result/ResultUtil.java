package com.example.demo.util.Result;

/**
 * @version 1.0
 * @Author chenglong
 * @className ResultUtil
 * @Description 响应结果生成工具
 * @Date 2025-07-22
 */
public class ResultUtil {

    //默认200成功
    public static <T> Result<T> success(T data) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS).setData(data);
        return result;
    }
    //自定义code成功+data
    public static <T> Result<T>  defineSuccess(ResultCode code, T data) {
        Result result = new Result<>();
        return result.setCode(code).setData(data);
    }

    //默认400返回失败
    public static <T> Result<T> fail(String message) {
        Result result = new Result();
        result.setCode(ResultCode.ERROR).setMessage(message);
        return result;
    }
    //自定义code失败+message
    public static <T> Result<T> defineFail(ResultCode code, String message){
        Result result = new Result();
        result.setCode(code).setMessage(message);
        return result;
    }
    //自定义返回信息
    public static <T> Result<T> define(ResultCode code, String message, T data){
        Result result = new Result();
        result.setCode(code).setMessage(message).setData(data);
        return result;
    }
}
