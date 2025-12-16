package com.htn.entity;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "media_relation")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaRelation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MEDIA_ID")
    private Long mediaId;
    @Column(name = "RELATION_ID")
    private Long relationId;
    @Column(name = "RELATION_CD")
    private String relationCd;
    @Column(name = "RELATION_TYPE")
    private String relationType;
    @Column(name = "MEDIA_ORDER")
    private Integer mediaOrder;
    @Column(name = "IS_PRIMARY")
    private String isPrimary;
}

