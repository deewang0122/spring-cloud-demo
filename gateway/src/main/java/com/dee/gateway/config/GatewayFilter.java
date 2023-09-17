package com.dee.gateway.config;

import com.dee.basekit.config.AbstractGatewayFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GatewayFilter extends AbstractGatewayFilter {
    @Override
    public long getExpireTime() {
        return 3600000L;
    }
}
