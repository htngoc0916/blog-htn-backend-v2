package com.htn.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tags")
public class Tag extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TAG_NAME")
    private String tagName;
    @Column(name = "TAG_SLUG")
    private String tagSlug;
    @Column(name = "TAG_TYPE")
    private String tagType;
    @Column(name = "TAG_COLOR")
    private String tagColor;
    @Column(name = "TAG_ORD")
    private Integer tagOrd;
    @Column(name = "TAG_DES")
    private String tagDes;

//    @JsonIgnore
//    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "tags")
//    private Set<Post> posts = new HashSet<>();
}