package com.dc.framework.exception;

import com.dc.framework.enums.ErrorCode;
import com.dc.framework.enums.ErrorCodeEnum;
import lombok.Data;

/**
 * 业务异常
 */
@Data
public class BizException extends RuntimeException {

    private Integer code;

    private String message;

    public BizException(String message) {
        super(message);
        this.code = ErrorCodeEnum.FAIL.getCode();
        this.message = message;
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
        this.code = ErrorCodeEnum.FAIL.getCode();
        this.message = message;
    }

    public BizException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

}
