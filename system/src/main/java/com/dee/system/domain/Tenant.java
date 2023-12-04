package com.dee.system.domain;

import com.dee.system.global.BaseGlobalDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EqualsAndHashCode(callSuper = true) // 生成equals/hashCode方法时包含其父类的属性
@Data
@Entity
@Table(name = "system_tenant")
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Comment("租户信息表")
public class Tenant extends BaseGlobalDomain {

    @Column(nullable = false)
    @Comment("租户名称")
    private String name;

    @Column(nullable = false)
    @Comment("租户类型")
    private String type;

    @Column(nullable = false)
    @Comment("租户状态")
    private String status;

    @Comment("租户父级Id")
    private String parentId = "-1";

    @Column(nullable = false)
    @Comment("租户备注")
    private String remark;

}
