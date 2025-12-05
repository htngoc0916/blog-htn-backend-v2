package com.htn.entity;

import com.htn.utils.Utils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "USED_YN", length = 1)
    private String usedYn = "Y";

    @CreatedDate
    @Column(name = "REG_DT", updatable = false)
    private Date regDt;

    @Column(name = "REG_ID", updatable = false)
    private Long regId;

    @Column(name = "MOD_DT", insertable = false)
    private Date modDt;

    @Column(name = "MOD_ID", insertable = false)
    private Long modId;


    @PrePersist
    public void onCreate() {
        this.regDt = new Date();
        this.regId = Utils.getCurrentUserId();
    }

    @PreUpdate
    public void onUpdate() {
        this.modDt = new Date();
        this.modId = Utils.getCurrentUserId();
    }
}
