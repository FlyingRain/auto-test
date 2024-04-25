package com.flyingrain.autotest.domain.utils;


import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;
import com.flyingrain.autotest.common.util.FunctionEnum;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class FunctionExecuteHelper {

    private static final Logger logger = LoggerFactory.getLogger(FunctionExecuteHelper.class);

    public static String executeFunction(String method, String... params) {
        if (!StringUtils.hasText(method)) {
            logger.error("method is empty！");
            throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "提取方法为空!");
        }
        String validMethod = method.trim().toLowerCase();
        FunctionEnum functionEnum = FunctionEnum.codeOf(validMethod);
        if (functionEnum == null) {
            logger.error("not support function:[{}]", method);
            throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "不支持的方法：" + method);
        }
        String result = null;
        switch (functionEnum) {
            case NOW:
                String format = (params == null || params.length == 0 || !StringUtils.hasText(params[0].trim())) ? "yyyy-MM-dd HH:mm:ss" : unwrapParam(params[0]);
                DateFormat dateFormat = new SimpleDateFormat(format);
                result = dateFormat.format(new Date());
                break;
            case URL_DECODE:
                if (params == null || params.length == 0 || !StringUtils.hasText(params[0].trim())) {
                    throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "urlDecode 参数为空" + method);
                }
                String encodeData = unwrapParam(params[0]);
                result = URLDecoder.decode(encodeData, StandardCharsets.UTF_8);
                break;
            case URL_ENCODE:
                if (params == null || params.length == 0 || !StringUtils.hasText(params[0].trim())) {
                    throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "urlEncode 参数为空" + method);
                }
                String originData = unwrapParam(params[0]);
                result = URLEncoder.encode(originData, StandardCharsets.UTF_8);
                break;
            case BASE64_DECODE:
                if (params == null || params.length == 0 || !StringUtils.hasText(params[0].trim())) {
                    throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "base64Decode 参数为空" + method);
                }
                String encode = unwrapParam(params[0]);
                byte[] temp = Base64.getDecoder().decode(encode.getBytes(StandardCharsets.UTF_8));
                result = new String(temp, StandardCharsets.UTF_8);
                break;
            case BASE64_ENCODE:
                if (params == null || params.length == 0 || !StringUtils.hasText(params[0].trim())) {
                    throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "base64Encode 参数为空" + method);
                }
                String decode = unwrapParam(params[0]);
                byte[] tempData = Base64.getEncoder().encode(decode.getBytes(StandardCharsets.UTF_8));
                result = new String(tempData, StandardCharsets.UTF_8);
                break;
            default:
                logger.error("not support function:" + method);
                throw new AutoTestException(AutoTestResultCodeEnum.NOT_SUPPORT_METHOD);
        }
        return result;
    }

    private static String unwrapParam(String param) {
        if (param.startsWith("'") && param.endsWith("'")) {
            return param.substring(1, param.length() - 1);
        }
        return param;
    }


}
