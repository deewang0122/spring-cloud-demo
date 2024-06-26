package com.dee.system.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserEnum {
    TYPE_IN(1, "内部员工", "内部员工"),
    TYPE_VISITOR(2, "游客/访客", "游客/访客"),
    TYPE_OUT(3, "第三方员工", "第三方员工"),
    TYPE_DEFAULT(1, "内部员工", "默认内部员工");

    @JsonValue
    @EnumValue
    private final Integer key;

    private final String value;

    private final String remark;

    public static UserEnum instance(Integer key) {
        for (UserEnum userEnum : UserEnum.values()) {
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
