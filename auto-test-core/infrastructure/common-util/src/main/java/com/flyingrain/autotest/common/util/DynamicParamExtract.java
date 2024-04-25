package com.flyingrain.autotest.common.util;

import com.flyingrain.autotest.common.util.exception.AutoTestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DynamicParamExtract {

    private static final Logger logger = LoggerFactory.getLogger(DynamicParamExtract.class);

    public static List<String> extractParam(String str) {
        List<String> serviceParams = new ArrayList<>();
        if (!StringUtils.hasText(str)) {
            return new ArrayList<>();
        }
        int startIndex = 0, endIndex = 0;
        for (int i = 1; i < str.length(); i++) {
            if (Character.toString(str.charAt(i)).equals("{") && Character.toString(str.charAt(i - 1)).equals("$")) {
                if (startIndex != 0) {
                    logger.error("param format error!at str index:[{}]", i);
                    throw new AutoTestException(AutoTestResultCodeEnum.TEMPLATE_ERROR.getCode(),"服务不支持嵌套，嵌套请在用例配置");
                }
                startIndex = i + 1;
            }
            if (Character.toString(str.charAt(i)).equals("}")) {
                endIndex = i;
                if (startIndex == 0) {
                    logger.warn("not valid,continue");
                    continue;
                }
                if (startIndex >= endIndex) {
                    logger.error("param format error!at str index:[{}]", i);
                    throw new AutoTestException(AutoTestResultCodeEnum.TEMPLATE_ERROR);
                }
                String param = str.substring(startIndex, endIndex);
                serviceParams.add(param);
                startIndex = 0;
            }
        }
        return serviceParams;
    }
}
