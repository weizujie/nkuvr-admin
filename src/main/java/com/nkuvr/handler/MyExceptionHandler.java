package com.nkuvr.handler;

import com.nkuvr.utils.ResultUtil;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 *
 * @Author: weizujie
 * @Date: 2021/1/4
 * @Github: https://github.com/weizujie
 */

@RestControllerAdvice
public class MyExceptionHandler {

    /**
     * Shiro 注解 @RequiresRoles
     * 如果访问没有授权的地址，会报 AuthorizationException 异常，但是捕获不了
     * 可以通过该种方式进行处理
     */
    @ExceptionHandler(AuthorizationException.class)
    public ResultUtil handlerAuthorizationException(AuthorizationException e) {
        return ResultUtil.error().message("未授权资源禁止访问");
    }

}
