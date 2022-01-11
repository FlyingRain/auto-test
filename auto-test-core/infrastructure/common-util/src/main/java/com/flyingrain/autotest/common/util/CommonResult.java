package com.flyingrain.autotest.common.util;

public class CommonResult<T> {

    private String code;

    private String message;

    private T data;

    public CommonResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

    public CommonResult() {
    }

    public CommonResult(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public static <T> CommonResult<T> success(T data){
        CommonResult<T> commonResult = new CommonResult<>(ResultCodeEnum.SUCCESS);
        commonResult.setData(data);
        return commonResult;
    }

    public static CommonResult fail(){
        return new CommonResult(ResultCodeEnum.FAIL);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
