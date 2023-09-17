package com.dee.basekit.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 封装Spring BCryptPasswordEncoder.java工具类
 */
public class BcryptUtils {
    /**
     * 字符串加密
     * @param encodeStr 需要加密的字符串
     * @return String
     */
    public static String encode(String encodeStr) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(encodeStr);
    }

    /**
     * 判断是否可以成功解密
     *
     * @param rawPassword     真实密码
     * @param encodedPassword 加密密码
     * @return boolean
     */
    public static boolean matches(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }
}
