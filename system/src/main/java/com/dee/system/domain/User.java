package com.dee.system.domain;

import com.dee.system.global.BaseGlobalDomain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true) //生成equals/hashCode方法时包含其父类的属性
@Data
@Entity
@Table(name = "system_user")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseGlobalDomain {

    private String name;

    private String password;

    private String code;

    private String email;

    private Integer status;

}
