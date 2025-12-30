package com.htn.entity;

import com.htn.utils.SecurityUtil;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu_hist")
@Builder
public class MenuHist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MENU_ID", nullable = false)
    private Long menuId;
    @Column(name = "MENU_CODE", nullable = false)
    private String menuCode;
    @Column(name = "HIST_TYPE", nullable = false)
    private String histType;

    @Column(name = "BEFORE_DATA", columnDefinition = "json")
    private String beforeData;
    @Column(name = "AFTER_DATA", columnDefinition = "json")
    private String afterData;

    @CreatedDate
    @Column(name = "REG_DT", updatable = false)
    private Date regDt;

    @Column(name = "REG_ID", updatable = false)
    private Long regId;

    @PrePersist
    public void onCreate() {
        this.regDt = new Date();
        this.regId = SecurityUtil.getCurrentUserId();
    }

}
