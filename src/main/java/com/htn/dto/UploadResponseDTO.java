package com.htn.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadResponseDTO {
    private Long id;
    private String fileTitle;
    private String filePath;
    private String fileName;
    private String fileOriginalName;
    private String fileType;
    private Long fileSize;
    @Builder.Default
    private String usedYn = "Y";
    private Long regId;
}
