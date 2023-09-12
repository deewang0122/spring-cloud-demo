package com.dee.basekit.config;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

// TODO...2023/9/11: 待优化
public class BaseRedisManager {

    private static RedisTemplate<String, Object> redisTemplate;

    private static StringRedisTemplate stringRedisTemplate;

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
}
