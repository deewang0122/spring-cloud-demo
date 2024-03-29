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

@EqualsAndHashCode(callSuper = true) //生成equals/hashCode方法时包含其父类的属性
@Data
@Entity
@Table(name = "system_user")
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Comment("用户信息表")
public class User extends BaseGlobalDomain {
    /**
     * 用户名称
     */
    @Column(nullable = false)
    @Comment("姓名")
    private String name;

    @Column(nullable = false, unique = true)
    @Comment("用户编码")
    private String code;

    @Column(unique = true)
    @Comment("用户邮箱")
    private String email;

    @Column(nullable = false)
    @Comment("用户密码")
    private String password;

    @Column(nullable = false)
    @Comment("用户状态")
    private Integer status;

    @Column(name = "remark", length = 1024)
    @Comment("备注信息")
    private String remark;

}
