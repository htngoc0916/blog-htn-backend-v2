package com.htn.entity;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "media_master")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaMaster extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FILE_PATH")
    private String filePath;
    @Column(name = "FILE_NAME")
    private String fileName;
    @Column(name = "FILE_NAME_ORG")
    private String fileNameOrg;
    @Column(name = "FILE_TYPE")
    private String fileType;
    @Column(name = "FILE_SIZE")
    private Long fileSize;
    @Column(name = "MEDIA_TYPE")
    private String mediaType;
    @Column(name = "STORAGE_TYPE")
    private String storageType;
    @Column(name = "WIDTH")
    private Integer width;
    @Column(name = "HEIGHT")
    private Integer height;
    @Column(name = "DURATION")
    private Float duration;
}