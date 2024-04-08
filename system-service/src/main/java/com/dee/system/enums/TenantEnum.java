package com.dee.system.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TenantEnum {
    TYPE_IN(1, "内部组织", "内部组织"),
    TYPE_OUT(3, "第三方组织", "第三方组织"),
    TYPE_DEFAULT(1, "内部组织", "默认内部组织");

    @JsonValue
    @EnumValue
    private final Integer key;

    private final String value;

    private final String remark;

    public static TenantEnum instance(Integer key) {
        for (TenantEnum userEnum : TenantEnum.values()) {
            if (userEnum.key == key) {
                return userEnum;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("UserEnum(key=%d, value=%s, remark=%s)", this.key, this.value, this.remark);
    }

}
