package com.htn.service;

import com.htn.dto.FileUploadDTO;
import com.htn.dto.FileUploadMultipleDTO;
import com.htn.entity.FileMaster;
import org.springframework.core.io.Resource;

import java.util.List;

public interface FilesStorageService {
    FileMaster uploadFile(FileUploadDTO file);
    List<FileMaster> uploadMultipleFiles(FileUploadMultipleDTO files);
    Resource fileDownload(String fileName);
    boolean deleteFile(String fileName);
    FileMaster getFileById(Long id);
    FileMaster findByFileName(String fileName);
}
