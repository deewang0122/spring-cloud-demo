package com.dee.system.global;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.dee.basekit.mvc.domain.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseGlobalDomain extends BaseDomain {
    @TableId
    private String id;



    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
