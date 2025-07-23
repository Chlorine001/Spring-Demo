package com.example.demo.exception;

import com.example.demo.util.Result.Result;
import com.example.demo.util.Result.ResultCode;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @Author chenglong
 * @className NotFoundException
 * @Description
 * @Date 2025-07-23
 */
public class NotFoundException implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public Result error() {
        Result result = new Result();
        // 4、接口不存在
        result.setCode(ResultCode.NOT_FOUND).setMessage("接口不存在");
        return result;
    }

}
