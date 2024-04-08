package com.dee.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dee.system.enums.LoginEnum;
import com.dee.system.enums.StatusEnum;
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
    private StatusEnum status;

    @TableField("user_id")
    private String userId;

    @TableField("type")
    private LoginEnum type;

}
