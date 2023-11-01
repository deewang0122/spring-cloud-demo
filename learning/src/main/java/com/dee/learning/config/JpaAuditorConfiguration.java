package com.dee.learning.config;

import com.dee.basekit.config.AbstractJpaAuditorConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Optional;

/**
 * Jpa自动填充属性
 */
@Configuration
@Slf4j
@Order(2)
public class JpaAuditorConfiguration extends AbstractJpaAuditorConfiguration {
    @Override
    public Optional<String> getCurrentAuditor() {
        return super.getCurrentAuditor();
    }
}
