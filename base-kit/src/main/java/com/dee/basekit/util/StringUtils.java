package com.dee.basekit.util;

import org.springframework.lang.Nullable;

/**
 * String字符串工具类
 *
 * @author Dee
 */
public class StringUtils {
    /**
     * 判断字符串是否为空
     *
     * @param str 字符串
     * @return boolean
     */
    public static boolean isEmpty(@Nullable String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotEmpty(@Nullable String str) {
        return str != null && !str.isEmpty();
    }

    public static boolean isEqual(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return true;
        }

        if (str1 == null) {
            return false;
        }

        if (str2 == null) {
            return false;
        }

        return str1.equals(str2);
    }

}
