package com.dee.system.domain;

import com.dee.system.global.BaseGlobalDomain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "system_account")
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseGlobalDomain {

    private String account;

    private Integer type;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
