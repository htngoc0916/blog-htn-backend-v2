package com.htn.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
@Builder
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CATEGORY_CD", nullable = false)
    private String categoryCd;
    @Column(name = "CATEGORY_NM", nullable = false)
    private String categoryNm;
    @Column(name = "CATEGORY_DES")
    private String categoryDes;
    @Column(name = "CATEGORY_ORD")
    private int categoryOrd;
    @Column(name = "PARENT_CD")
    private String parentCd;
}
