package com.dee.system.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum StatusEnum {

    ENABLE(1, "启用", "有效"),

    DISABLE(2, "禁止", "无效，不能恢复"),

    LOCKED(3, "锁定", "可解冻恢复"),

    DEFAULT(1, "启用", "有效");

    @EnumValue
    @JsonValue
    private final Integer key;

    private final String value;

    private final String remark;

    public static StatusEnum instance(Integer key) {
        for (StatusEnum userEnum : StatusEnum.values()) {
            if (Objects.equals(userEnum.key, key)) {
                return userEnum;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return String.format("StatusEnum(key=%d, value=%s, remark=%s)", this.key, this.value, this.remark);
    }

}
