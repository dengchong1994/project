package com.dc.framework.enums;

public enum ErrorCodeEnum implements ErrorCode {

    SUCCESS(0, "成功"),

    FAIL(-1, "失败"),
    ;

    private Integer code;

    private String message;

    ErrorCodeEnum(Integer code, String message) {
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
