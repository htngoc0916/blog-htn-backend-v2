package com.htn.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class FileUploadDTO {
    private MultipartFile file;
    private String fileTitle;

    //dung cho update
    private Long regId;
}
