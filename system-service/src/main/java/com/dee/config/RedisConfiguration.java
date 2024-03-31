package com.dee.config;

import com.dee.basekit.config.AbstractRedisConfiguration;
import com.dee.basekit.config.GlobalRedisManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfiguration extends AbstractRedisConfiguration {
    /**
     * redisTemplate相关配置
     */
    @Bean(value = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        return GlobalRedisManager.init(createRedisTemplate(factory));
    }

    /**
     * stringRedisTemplate
     */
    @Bean
    @ConditionalOnMissingBean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
        return createStringRedisTemplate(factory);
    }
}
