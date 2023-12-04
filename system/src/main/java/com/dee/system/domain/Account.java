package com.dee.system.domain;

import com.dee.system.global.BaseGlobalDomain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "system_account")
@NoArgsConstructor
@AllArgsConstructor
@Comment("登录账号表")
public class Account extends BaseGlobalDomain {

    @Column(name = "account", nullable = false, unique = true)
    @Comment("登录账号")
    private String account;

    @Column(nullable = false)
    @Comment("账号类型")
    private Integer type;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Comment("用户ID")
    private User user;
}
