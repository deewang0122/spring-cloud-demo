package com.dee.system.global;

import com.dee.basekit.mvc.domain.BaseDomain;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
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

    @CreatedBy
    private String createBy;

    @CreatedDate
    private LocalDateTime createTime;

    @LastModifiedBy
    private String updateBy;

    @LastModifiedDate
    private LocalDateTime updateTime;
}
