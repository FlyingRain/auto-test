package com.flyingrain.autotest.common.util;

public class NumberUtils {
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
