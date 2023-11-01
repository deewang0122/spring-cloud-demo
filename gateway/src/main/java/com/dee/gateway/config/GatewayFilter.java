package com.dee.gateway.config;

import com.dee.basekit.config.AbstractGatewayFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableConfigurationProperties({WhitelistFilterProperties.class})
public class GatewayFilter extends AbstractGatewayFilter {
    @Autowired
    WhitelistFilterProperties whitelistFilterProperties;

    @Override
    public long getExpireTime() {
        return 3600000L;
    }

    @Override
    protected boolean verifyWhitelist(String requestPath) {
        return whitelistFilterProperties.getAllowPaths().contains(requestPath);
    }
}
