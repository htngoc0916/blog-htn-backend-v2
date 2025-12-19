package com.htn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "menus")
public class Menu extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "MENU_CODE")
    private String menuCode;
    @Column(name = "MENU_NAME")
    private String menuName;
    @Column(name = "MENU_NAME_ENG")
    private String menuNameEng;
    @Column(name = "PARENT_CD")
    private String parentCd;
    @Column(name = "MENU_TYPE")
    private String menuType;
    @Column(name = "MENU_ORD")
    private Integer menuOrd;
    @Column(name = "MENU_URL")
    private String menuUrl;
    @Column(name = "MENU_ICON")
    private String menuIcon;

    @JsonIgnore
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuPermissionConfig> permissionConfigs;
}
