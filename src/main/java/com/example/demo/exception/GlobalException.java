package com.example.demo.exception;

import com.example.demo.util.Result.Result;
import com.example.demo.util.Result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.net.ConnectException;

/**
 * @version 1.0
 * @Author chenglong
 * @className GlobalExceptionHandler
 * @Description 异常处理器全局生效
 * @Date 2025-07-22
 */
@RestControllerAdvice
public class GlobalException extends RuntimeException {

    // 创建日志实例
    private static final Logger log = LoggerFactory.getLogger(GlobalException.class);

    private final Environment env;

    public GlobalException(Environment env) {
        this.env = env;
    }

    // 处理自定义业务异常
//    @ExceptionHandler(ApiException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public Result handleBusinessException(HttpServletRequest request, ApiException e) {
//        log.warn("业务异常 [URL: {}, IP: {}] - code: {}, msg: {}",
//                request.getRequestURL(),
//                request.getRemoteAddr(),
//                e.getCode(),
//                e.getMessage());
//
//        return new Result(e.getCode(), e.getMessage(), null);
//    }

    // 处理系统级异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleException(HttpServletRequest request, Exception e) {
        // 记录完整错误堆栈
        log.error("系统异常 =>[URL: {}, Method: {}, IP: {}], Error: ",
                request.getRequestURL(),
                request.getMethod(),
                request.getRemoteAddr(),
                e);  // 关键：将异常对象作为最后一个参数传入
        // 区分环境返回错误信息
        boolean isProd = "prod".equals(env.getProperty("spring.profiles.active"));
        return new Result(
                ResultCode.INTERNAL_SERVER_ERROR.getCode(),
                isProd ? "系统服务异常，请稍后再试" : e.getClass().getName() + ": " + e.getMessage(),
                null
        );
    }

    //错误请求
    @ExceptionHandler(value = {
            MethodArgumentNotValidException.class,  // 参数校验异常
            ConstraintViolationException.class     // JPA参数校验异常
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleValidationException(Exception e) {
        String message = e.getMessage().split(":")[0];  // 提取简洁错误信息
        return new Result(ResultCode.PARAM_ERROR.getCode(), message, null);
    }

    // 数据库异常
    @ExceptionHandler(DataAccessException.class)
    public Result handleDataException(DataAccessException e) {
        log.error("数据库操作异常", e);
        return new Result(ResultCode.ERROR.getCode(), "数据库服务异常", null);
    }

    // 网络请求异常
    @ExceptionHandler(ConnectException.class)
    public Result handleConnectException(ConnectException e) {
        log.error("外部服务连接失败", e);
        return new Result(ResultCode.ERROR.getCode(), "服务暂时不可用", null);
    }

}