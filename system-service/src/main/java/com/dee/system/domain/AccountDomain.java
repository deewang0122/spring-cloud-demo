package com.dee.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dee.system.enums.AccountEnum;
import com.dee.system.global.BaseGlobalDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@TableName("system_account")
public class AccountDomain extends BaseGlobalDomain {

    @TableField("account")
    private String account;

    @TableField("status")
    private Integer status = AccountEnum.STATUS_ENABLE.getKey();

    @TableField("user_id")
    private String userId;

}
