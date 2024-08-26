package com.furniture.shopping.exception;

/**
 * 描述：     统一异常
 */
public class FurnitureException extends RuntimeException {

    private final Integer code;
    private final String message;

    public FurnitureException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public FurnitureException(FurnitureExceptionEnum exceptionEnum) {
        this(exceptionEnum.getCode(), exceptionEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
