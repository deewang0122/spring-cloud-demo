package com.dee.basekit.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.util.StringUtils;

import java.util.Optional;

public abstract class AbstractJpaAuditorConfiguration implements AuditorAware<String> {
    @SuppressWarnings("NullableProblems")
    @Override
    public Optional<String> getCurrentAuditor() {
        String loginUserId = LoginComponent.getUserId();
        if (StringUtils.hasLength(loginUserId)) {
            return Optional.of(loginUserId);
        }
        return Optional.empty();
    }
}
