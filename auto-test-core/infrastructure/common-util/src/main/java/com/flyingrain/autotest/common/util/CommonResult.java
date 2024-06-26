package com.flyingrain.autotest.common.util;

public class CommonResult<T> {

    private boolean success;

    private String code;
    private String message;
    private T data;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.setSuccess(true);
        result.setData(data);
        result.setCode("200");
        return result;
    }

    public static <T> CommonResult<T> fail(String code,String message) {
        CommonResult<T> result = new CommonResult<>();
        result.setSuccess(false);
        result.setMessage(message);
        result.setCode(code);
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
