package com.flyingrain.autotest.common.util;

/**
 * @author wally
 * @date 2021-12-09
 */
public enum AutoTestResultCodeEnum {

    SUCCESS("200", "成功"),

    FAIL("500", "失败"),

    MODEL_NOT_EXIST("501", "模块不存在"),

    CASE_DEP_CYCLE("502", "用例循环依赖"),

    MODEL_NOT_LOADED("503", "模块未装载"),

    NO_TEST_CASE("504", "没有测试用例"),

    NO_TYPE_HANDLE("505", "无法解析的类型"),

    ERROR_TYPE_FORMAT("506", "类型格式错误"),

    RESULT_NOT_EXIST("507", "依赖结果不存在"),

    PARAM_ERROR("508", "请求参数错误"),

    NETWORK_ERROR("509", "网络请求错误"),

    NOT_SUPPORT_PROTOCOL("510", "不支持的协议类型"),

    NOT_SUPPORT_REQUEST_TYPE("511", "不支持的请求类型"),

    NOT_SUPPORT_RESULT_TYPE("512", "不支持的结果类型"),

    NO_TEMPLATE_KEY("513", "请求模板key缺失"),

    NO_JUDGE("514", "缺失判断器"),

    CASE_RUN_ERROR("515", "依赖用例运行失败"),
    TEMPLATE_ERROR("516","模板格式错误"),


    USER_NOT_EXIST("550", "用户不存在"),
    USER_NOT_LOGIN("551", "用户尚未登录或登录已过期"),

    DEPEND_NOT_CLEAN("580","存在未清除的依赖"),

    PARAM_NOT_EXIST("590","参数值不存在"),
    ;


    private String code;

    private String message;

    AutoTestResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
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
}
