package com.dee.basekit.config;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

// TODO...2023/9/11: 待优化
public class GlobalRedisManager {

    private static RedisTemplate<String, Object> redisTemplate;

    public static RedisTemplate<String, Object> init(RedisTemplate<String, Object> objectRedisTemplate) {
        redisTemplate = objectRedisTemplate;
        return redisTemplate;
    }

    public static Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public static Object set(String key, Object value) {
        // TODO...2023/9/11: 待优化
        redisTemplate.opsForValue().set(key, value);

        return true;
    }

    public static Object setAndExpire(String key, Object value, Long expireTime) {
        // TODO...2023/9/11: 待优化
        redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);

        return true;
    }

    public static Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 设置Key值过期时间
     *
     * @param key        Key值
     * @param expireTime 过期时间，单位：秒
     * @return Boolean
     */
    public static Boolean expire(String key, Long expireTime) {
        return redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
    }

}
