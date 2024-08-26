package com.furniture.shopping.exception;

import com.furniture.shopping.common.ApiRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述：     处理统一异常的handler
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleException(Exception e) {
        log.error("Default Exception: ", e);
        return ApiRestResponse.error(FurnitureExceptionEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(FurnitureException.class)
    @ResponseBody
    public Object handleImoocMallException(FurnitureException e) {
        log.error("FurnitureException: ", e);
        return ApiRestResponse.error(e.getCode(), e.getMessage());
    }
}
