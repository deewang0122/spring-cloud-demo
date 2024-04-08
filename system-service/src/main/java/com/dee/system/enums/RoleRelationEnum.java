package com.dee.system.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleRelationEnum {
    TYPE_TENANT("tenant", "租户角色关系"),
    TYPE_USER("user", "用户角色关系");

    @EnumValue
    @JsonValue
    private final String key;

    private final String value;
}
