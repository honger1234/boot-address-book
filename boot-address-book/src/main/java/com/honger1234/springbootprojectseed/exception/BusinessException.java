package com.honger1234.springbootprojectseed.exception;

/**
 * @Description: 服务（业务）异常如“ 账号或密码错误 ”
 * @author: zt
 */
public class BusinessException extends RuntimeException {

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}
