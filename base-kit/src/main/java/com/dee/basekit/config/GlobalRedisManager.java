package com.dee.basekit.config;

import org.springframework.data.redis.core.RedisTemplate;

// TODO...2023/9/11: 待优化
public class GlobalRedisManager {

    private  static RedisTemplate<String, Object> redisTemplate;

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

    public static Object set(String key, Object value, Long expireTime) {
        // TODO...2023/9/11: 待优化
        redisTemplate.opsForValue().set(key, value, expireTime);

        return true;
    }

    public static Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }
}
