package kaizen.shiro.exception;

import kaizen.shiro.utils.ResultUtil;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 *
 * @Author: weizujie
 * @Date: 2020/12/7
 * @Github: https://github.com/weizujie
 */

@RestControllerAdvice
public class MyExceptionHandler {

    /**
     * Shiro 注解 @RequiresRoles
     * 如果访问没有授权的地址，会报 AuthorizationException 异常，但是捕获不了
     * 可以通过该种方式进行处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(AuthorizationException.class)
    public ResultUtil handlerAuthorizationException(AuthorizationException e) {
        return ResultUtil.fail("未授权资源禁止访问");
    }

}
