package com.htn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity{

    @Column(name = "USED_YN", length = 1)
    private String usedYn;

    @CreatedDate
    @Column(name = "REG_DT", updatable = false)
    private Date regDt;

    @CreatedBy
    @Column(name = "REG_ID", updatable = false)
    private String regId;

    @LastModifiedDate
    @Column(name = "MOD_DT")
    private Date modDt;

    @LastModifiedBy
    @Column(name = "MOD_ID")
    private String modId;
}
