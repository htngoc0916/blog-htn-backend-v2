package com.htn.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaResponseDTO {
    private Long id;
    private String fileTitle;
    private String filePath;
    private String fileName;
    private String fileNameOrg;
    private String fileType;
    private Long fileSize;
    private String mediaType;
    private String storageType;
    private Integer width;
    private Integer height;
    private Float duration;

    private int relationCount;

    private String usedYn;
    private String regDt;
    private String regId;
    private String modId;
    private String modDt;
}
