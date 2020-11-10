package com.dc.framework.model.entity;

import com.dc.framework.enums.ErrorCodeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success() {
        return new Result<>(ErrorCodeEnum.SUCCESS.getCode(), null, null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ErrorCodeEnum.SUCCESS.getCode(), null, data);
    }

    public static <T> Result<T> success(String msg, T data) {
        return new Result<>(ErrorCodeEnum.SUCCESS.getCode(), msg, data);
    }

    public static <T> Result<T> success(Integer code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    public static <T> Result<T> fail(T data) {
        return new Result<>(ErrorCodeEnum.FAIL.getCode(), null, data);
    }

    public static <T> Result<T> fail(Integer code, String msg) {
        return new Result<>(code, msg, null);
    }

    public static <T> Result<T> fail(Integer code, String msg, T data) {
        return new Result<>(code, msg, data);
    }
}
