package com.flyingrain.autotest.common.util;

import java.util.HashMap;
import java.util.Map;

public class RunTimeContext {

    private static final InheritableThreadLocal<Map<String, Object>> runtimeContext = new InheritableThreadLocal<>();

    public static String yundaCookie;
    public static void put(String key, Object value) {
        Map<String, Object> cache = runtimeContext.get();
        if (cache == null) {
            cache = new HashMap<>();
            runtimeContext.set(cache);
        }
        cache.put(key, value);
    }

    public static <T> T get(String key) {
        Map<String, Object> cache = runtimeContext.get();
        if (cache == null) {
            cache = new HashMap<>();
            runtimeContext.set(cache);
        }
        Object value = cache.get(key);
        return value == null ? null : (T) value;
    }

}
