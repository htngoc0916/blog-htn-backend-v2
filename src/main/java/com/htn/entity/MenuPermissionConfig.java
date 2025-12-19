package com.htn.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu_permission_config")
@Builder
public class MenuPermissionConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID", nullable = false)
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERMISSION_ID", nullable = false)
    private Permission permission;

    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "SORT_ORDER")
    private Integer sortOrder;
    @Column(name = "USED_YN")
    private String usedYn;
}
