package com.honger1234.springbootprojectseed.exception;

import com.honger1234.springbootprojectseed.entity.Result;
import com.honger1234.springbootprojectseed.util.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 全局异常处理类
 * @author: zt
 * @date: 2020年3月26日
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    public Result businessException(BusinessException e){
        log.info("**************程序业务异常，信息："+e.getMessage());
        return ResultGenerator.genFailResult(e.getMessage());
    }

//    /**
//     * 404异常
//     * @param req
//     * @return
//     */
//    @ExceptionHandler(value = NoHandlerFoundException.class)
//    public Result notFoundException(HttpServletRequest req){
//        log.info("***********接口 [" + req.getRequestURI() + "] 不存在*************");
//        return ResultGenerator.gen404NotFoundResult("接口 [" + req.getRequestURI() + "] 不存在");
//    }

    /**
     * 请求方式不对
     * @param req
     * @return
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public Result methodNotSupport(HttpServletRequest req){
        log.info("接口 [" + req.getRequestURI() + "] 的请求方式不对，请换个姿势操作试试！");
        return ResultGenerator.gen404NotFoundResult("接口 [" + req.getRequestURI() + "] 的请求方式不对，请换个姿势操作试试！");
    }

    /**
     * 空指针异常
     * @param req
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    public Result nullPoint(HttpServletRequest req){
        log.info("接口 [" + req.getRequestURI() + "] 发生空指针异常");
        return ResultGenerator.gen404NotFoundResult("接口 [" + req.getRequestURI() + "] 发生空指针异常");
    }

    /**
     * token异常
     * @param e
     * @param req
     * @return
     */
    @ExceptionHandler(value = TokenException.class)
    public Result token(TokenException e,HttpServletRequest req){
        log.info("接口 [" + req.getRequestURI() + "] 认证失败,"+e.getMessage());
        return ResultGenerator.genUnauthorizedResult("接口 [" + req.getRequestURI() + "] 认证失败,"+e.getMessage());
    }

    /**
     * 其它异常
     * @param req
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result elseError(Exception e, HttpServletRequest req, Object handler){
        String message="接口 [" + req.getRequestURI() + "] 内部错误";
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
                    req.getRequestURI(),
                    handlerMethod.getBean().getClass().getName(),
                    handlerMethod.getMethod().getName(),
                    e.getMessage());
        }
        log.error(message, e);
        return ResultGenerator.genErrorResult(message);
    }

}
