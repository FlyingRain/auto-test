package com.flyingrain.autotest.common.util.exception;


import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;

/**
 * @author wally
 * @date 2021-12-09
 */
public class AutoTestException extends RuntimeException{


    private String code;

    private String message;

    public AutoTestException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public AutoTestException(AutoTestResultCodeEnum autoTestResultCodeEnum) {
        this.code = autoTestResultCodeEnum.getCode();
        this.message = autoTestResultCodeEnum.getMessage();
    }

    public AutoTestException(AutoTestResultCodeEnum autoTestResultCodeEnum,Throwable cause) {
        super(cause);
        this.code = autoTestResultCodeEnum.getCode();
        this.message = autoTestResultCodeEnum.getMessage();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
