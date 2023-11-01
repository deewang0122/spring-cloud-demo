package com.dee.basekit.config;

import lombok.Data;

import java.util.List;

@Data
public abstract class WhitelistConfiguration {
    private List<String> allowPaths;
}
