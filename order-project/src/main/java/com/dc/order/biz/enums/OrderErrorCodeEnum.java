package com.dc.order.biz.enums;

import com.dc.framework.enums.ErrorCode;

public enum OrderErrorCodeEnum implements ErrorCode {

    FAIL(-3, "系统繁忙请稍后重试");

    private Integer code;

    private String message;

    OrderErrorCodeEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
