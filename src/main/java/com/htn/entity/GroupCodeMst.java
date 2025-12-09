package com.htn.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "group_code_mst")
public class GroupCodeMst extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "GROUP_CD", nullable = false)
    private String groupCd;

    @Column(name = "GROUP_NM")
    private String groupNm;

    @Column(name = "GROUP_NM_ENG")
    private String groupNmEng;

    @Column(name = "GROUP_LENGTH")
    private Integer codeLength;

    @Column(name = "GROUP_DES")
    private String groupDes;

    @Column(name = "GROUP_ORD")
    private Integer groupOrd;
}
