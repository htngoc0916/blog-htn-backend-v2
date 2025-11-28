package com.htn.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "group_code_mst")
public class GroupCodeMst extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "GROUP_CD")
    private String groupCd;
    @Column(name = "GROUP_NM")
    private String groupNm;
    @Column(name = "GROUP_LENGTH")
    private Integer codeLength;
    @Column(name = "GROUP_DES")
    private String groupDes;
}
