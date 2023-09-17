package com.dee.basekit.config;

import lombok.extern.slf4j.Slf4j;

import static com.dee.basekit.constant.Constants.EXPIRE_TIME;

/**
 * 过滤抽象类
 */
@Slf4j
public abstract class AbstractFilter {

    /**
     * 过期时间
     *
     * @return expireTime
     */
    public long getExpireTime() {
        return EXPIRE_TIME;
    }
}
