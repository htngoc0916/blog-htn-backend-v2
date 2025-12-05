package com.htn.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @Column(name = "CODE_CD", updatable = false)
    private String codeCd;
    @Column(name = "CODE_NM")
    private String codeNm;
    @Column(name = "CODE_NM_ENG")
    private String codeNmEng;
    @Column(name = "CODE_DES")
    private String codeDes;
    @Column(name = "CODE_ORD")
    private String codeOrd;
    @Column(name = "ECT_1")
    private String ect1;
    @Column(name = "ECT_2")
    private String ect2;
    @Column(name = "ECT_3")
    private String ect3;
    @Column(name = "ECT_4")
    private String etc4;

    // Liên kết với Master
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_CD")
    private GroupCodeMst groupCodeMst;

    // Liên kết đệ quy (Parent)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_CD")
    private GroupCodeDtl parent;

    // Liên kết đệ quy (Children)
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GroupCodeDtl> children;
}