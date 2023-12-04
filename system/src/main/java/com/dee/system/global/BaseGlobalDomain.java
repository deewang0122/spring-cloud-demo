package com.dee.system.global;

import com.dee.basekit.mvc.domain.BaseDomain;
import com.dee.system.domain.Tenant;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class BaseGlobalDomain extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToMany(targetEntity = Tenant.class)
    @JoinColumn(name = "tenant_id", referencedColumnName = "id")
    @Comment("租户ID")
    private Tenant tenant;

    @CreatedBy
    @Comment("创建人")
    private String createBy;

    @CreatedDate
    @Comment("创建时间")
    private LocalDateTime createTime;

    @LastModifiedBy
    @Comment("修改人")
    private String updateBy;

    @LastModifiedDate
    @Comment("修改时间")
    private LocalDateTime updateTime;
}
