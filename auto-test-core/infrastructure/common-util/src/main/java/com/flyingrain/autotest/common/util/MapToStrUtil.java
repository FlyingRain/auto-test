package com.flyingrain.autotest.common.util;

import org.springframework.util.CollectionUtils;

import java.util.Map;

public class MapToStrUtil {

    public static String mapToStr(Map<String, String> params) {
        if (CollectionUtils.isEmpty(params)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        params.forEach((k, v) -> {
            result.append(k).append(": ").append(v).append(",");
        });
        return result.substring(0, result.length()-1);
    }
}
