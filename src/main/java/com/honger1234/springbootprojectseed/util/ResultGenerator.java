package com.honger1234.springbootprojectseed.util;


import com.honger1234.springbootprojectseed.entity.CodeEnum;
import com.honger1234.springbootprojectseed.entity.Result;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {

    /**
     * 成功相应，不带返回参数
     * @return
     */
    public static Result genSuccessResult() {
        return new Result<>(CodeEnum.SUCCESS);
    }

    /**
     * 成功相应，带返回参数
     * @param data 返回数据
     * @param <T> 数据类型
     * @return
     */
    public static <T> Result<T> genSuccessResult(T data) {
        return new Result<>(CodeEnum.SUCCESS,data);
    }

    /**
     * 操作失败，默认提示信息
     * @return
     */
//    public static <T> Result<T> genFailResult() {
//        Result<T> result = new Result<T>();
//        result.setCode(CodeEnum.FAIL.getCode());
//        result.setMsg(CodeEnum.FAIL.getMsg());
//        return result;
//    }

    /**
     * 操作失败，自定义失败提示信息
     * @param message
     * @return
     */
    public static <T> Result<T> genFailResult(String message) {
        Result<T> result = new Result<T>();
        result.setCode(CodeEnum.FAIL.getCode());
        result.setMsg(message);
        return result;
    }

    /**
     * 内部服务器错误
     * @return
     */
    public static Result genErrorResult(String msg){
        Result result = new Result(CodeEnum.INTERNAL_SERVER_ERROR);
        result.setMsg(msg);
        return result;
    }

    /**
     * 404错误
     * @return
     */
    public static Result gen404NotFoundResult(){
        return new Result(CodeEnum.NOT_FOUND);
    }

    /**
     * 404错误，自定义错误信息
     * @param msg
     * @return
     */
    public static Result gen404NotFoundResult(String msg){
        Result result = new Result();
        result.setCode(CodeEnum.NOT_FOUND.getCode());
        result.setMsg(msg);
        return result;
    }

    /**
     * 接口认证失败
     * @param msg
     * @return
     */
    public static Result genUnauthorizedResult(String msg){
        Result result = new Result();
        result.setCode(CodeEnum.UNAUTHORIZED.getCode());
        result.setMsg(msg);
        return result;
    }
}
