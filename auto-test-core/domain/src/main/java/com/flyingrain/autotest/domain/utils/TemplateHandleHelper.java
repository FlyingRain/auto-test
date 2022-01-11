package com.flyingrain.autotest.domain.utils;

import com.flyingrain.autotest.domain.constant.AutoTestResultCodeEnum;
import com.flyingrain.autotest.domain.exception.AutoTestException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.flyingrain.autotest.domain.constant.AutoTestConstants.DEFAULT_TYPE;

/**
 * @author wally
 * @date 2021-12-16
 */
public class TemplateHandleHelper {

    private static Logger logger = LoggerFactory.getLogger(TemplateHandleHelper.class);

    public static String extractParamType(String paramName) {
        if (StringUtils.isEmpty(paramName)) {
            return "";
        }
        if (paramName.contains(",")) {
            String[] paramAndType = paramName.split(",");
            String type = paramAndType[1];
            return getType(type);
        }
        return DEFAULT_TYPE;
    }

    public static String extractParamName(String paramName) {
        if (StringUtils.isEmpty(paramName)) {
            return "";
        }
        if (paramName.contains(",")) {
            String[] paramAndType = paramName.split(",");
            return paramAndType[0];
        }
        return paramName;

    }

    private static String getType(String type) {
        String[] typeName = type.split("=");
        if (typeName.length <= 1) {
            logger.error("error type format!type:[{}]", type);
            throw new AutoTestException(AutoTestResultCodeEnum.ERROR_TYPE_FORMAT);
        }
        return typeName[1];
    }

    public static boolean isPrimitive(Object o) {
        if (o == null) {
            return false;
        }
        Class clz = o.getClass();
        if (clz.isPrimitive()) {
            return true;
        }
        try {
            return ((Class) clz.getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
            return false;
        }
    }
}

