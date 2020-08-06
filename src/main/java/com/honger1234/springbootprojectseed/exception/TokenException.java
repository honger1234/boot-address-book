package com.honger1234.springbootprojectseed.exception;

/**
 * @Description: 服务（业务）异常如“ 账号或密码错误 ”
 * @author: zt
 */
public class TokenException extends RuntimeException {

    public TokenException() {
    }

    public TokenException(String message) {
        super(message);
    }

    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }

}
