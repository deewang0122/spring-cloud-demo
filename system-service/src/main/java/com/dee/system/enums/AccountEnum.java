package com.dee.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccountEnum {
    STATUS_ENABLE(1, "有效", "有效"),

    STATUS_DISABLE(2, "无效", "无效，不能恢复"),

    STATUS_LOCKED(3, "冻结", "可解冻恢复");

    private final Integer key;

    private final String value;

    private final String remark;

    @Override
    public String toString() {
        return String.format("AccountEnum(key=%d, value=%s, remark=%s)", this.key, this.value, this.remark);
    }

}
