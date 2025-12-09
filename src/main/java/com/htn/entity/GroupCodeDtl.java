package com.htn.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "group_code_dtl")
public class GroupCodeDtl extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "GROUP_CD", nullable = false)
    private String groupCd;

    @Column(name = "PARENT_CD", nullable = false)
    private String parentCd;

    @Column(name = "CODE_CD", nullable = false)
    private String codeCd;

    @Column(name = "CODE_NM", nullable = false)
    private String codeNm;

    @Column(name = "CODE_NM_ENG")
    private String codeNmEng;

    @Column(name = "CODE_DES")
    private String codeDes;

    @Column(name = "CODE_ORD")
    private Integer codeOrd;

    @Column(name = "ECT_1")
    private String ect1;

    @Column(name = "ECT_2")
    private String ect2;

    @Column(name = "ECT_3")
    private String ect3;

    @Column(name = "ECT_4")
    private String ect4;
}
