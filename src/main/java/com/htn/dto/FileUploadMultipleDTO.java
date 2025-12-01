package com.htn.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUploadMultipleDTO {
    private MultipartFile[] file;
    private String[] fileTitle;

    //update info
    private Long regId;
}
