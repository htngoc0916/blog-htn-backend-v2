package com.htn.service;

import com.htn.dto.FileUploadDTO;
import com.htn.dto.FileUploadMultipleDTO;
import com.htn.entity.MediaMaster;
import org.springframework.core.io.Resource;

import java.util.List;

public interface FilesStorageService {
    MediaMaster uploadFile(FileUploadDTO file);
    List<MediaMaster> uploadMultipleFiles(FileUploadMultipleDTO files);
    Resource fileDownload(String fileName);
    boolean deleteFile(String fileName);
    MediaMaster getFileById(Long id);
    MediaMaster findByFileName(String fileName);
}
