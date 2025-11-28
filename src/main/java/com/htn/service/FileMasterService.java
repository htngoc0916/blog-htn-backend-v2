package com.htn.service;

import com.htn.entity.FileMaster;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileMasterService {
    FileMaster uploadFile(MultipartFile file);
    List<FileMaster> uploadMultipleFiles(MultipartFile[] files);
    Resource fileDownload(String fileName);
    boolean deleteFile(String fileName);
    List<FileMaster> getAllFiles();
}
