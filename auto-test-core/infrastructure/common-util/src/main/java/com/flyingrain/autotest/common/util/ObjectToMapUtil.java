package com.flyingrain.autotest.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectToMapUtil {

    private static final Logger logger = LoggerFactory.getLogger(ObjectToMapUtil.class);

    public static Map<String, String> ObjToMap(Object target) {
        Map<String, String> params = new HashMap<>();
        try {
            Class<?> targetClass = target.getClass();
            Field[] fields = targetClass.getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);
                Object valueObj = f.get(target);
                String value = valueObj == null ? "" : valueObj.toString();
                params.put(f.getName(), value);
            }
        } catch (Exception e) {
            logger.error("obj to map failed!", e);
        }
        return params;

    }
}
