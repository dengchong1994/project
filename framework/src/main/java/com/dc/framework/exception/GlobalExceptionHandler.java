package com.dc.framework.exception;

import com.dc.framework.model.entity.Result;
import com.dc.framework.util.ExpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Result exceptionHandler(HttpServletResponse response, Exception e) {
        log.error("错误异常:{}", ExpUtil.buildErrorMessage(e));
        if (e instanceof DuplicateKeyException) {
            return Result.fail("主键冲突");
        }
        if (e instanceof BizException) {
            BizException exception = (BizException) e;
            return Result.fail(exception.getCode(), exception.getMessage());
        }
        return Result.fail(e.getMessage());
    }

}
