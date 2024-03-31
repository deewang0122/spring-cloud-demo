package com.dee.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LoginEnum {
    TYPE_CODE("code", "账号编码", "账号编码"),
    TYPE_PHONE("phone", "手机号码", "手机号码"),
    TYPE_EMAIL("email", "邮箱", "邮箱");

    private final String key;

    private final String value;

    private final String remark;


}
