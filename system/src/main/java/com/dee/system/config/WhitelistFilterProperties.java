package com.dee.system.config;

import com.dee.basekit.config.WhitelistConfiguration;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@EqualsAndHashCode(callSuper = true)
@ConfigurationProperties(prefix = "gateway.filter")
public class WhitelistFilterProperties extends WhitelistConfiguration {
}