package com.honger1234.springbootprojectseed.entity;

import lombok.Data;

/**
 * 响应码和说明枚举类
 */
public enum CodeEnum {

    SUCCESS(10000,"成功"),
    UNAUTHORIZED(10001,"未认证"),
    NOT_FOUND(10404,"接口不存在"),
    FAIL(40000,"失败"),
    INTERNAL_SERVER_ERROR(50000,"服务器内部错误");

    //用户模块



    /**
     * 响应状态码
     */
    private final int code;

    /**
     * 响应提示
     */
    private final String msg;

    CodeEnum(Integer code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    public int getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }

}
