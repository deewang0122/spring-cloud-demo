package com.dee.system.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "system_user")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseGlobalDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String password;

    private String code;

    private String email;

    User(String id) {
        this.id = id;
    }
}
