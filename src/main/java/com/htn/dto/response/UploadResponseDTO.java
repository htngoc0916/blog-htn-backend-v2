package com.htn.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadResponseDTO {
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
}
