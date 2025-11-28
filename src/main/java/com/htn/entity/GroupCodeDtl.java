package com.htn.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "group_code_dtl")
public class GroupCodeDtl extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "GROUP_CD")
    private String groupCd;
    @Column(name = "CODE_CD")
    private String codeCd;
    @Column(name = "CODE_NM")
    private String codeNm;
    @Column(name = "CODE_NM_ENG")
    private String codeNmEng;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PARENT_CD")
    private String parentCd;
    @Column(name = "ECT_1")
    private String ect1;
    @Column(name = "ECT_2")
    private String ect2;
    @Column(name = "ECT_3")
    private String ect3;
    @Column(name = "ECT_4")
    private String etc4;
}