package com.htn.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "PARENT_ID")
    private Long parentId;
    @Column(name = "MENU_ORD")
    private Integer menuOrd;
    @Column(name = "MENU_URL")
    private String menuUrl;
    @Column(name = "MENU_ICON")
    private String menuIcon;
}
