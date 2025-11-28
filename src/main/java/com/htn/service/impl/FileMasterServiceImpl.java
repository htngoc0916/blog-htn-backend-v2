package com.htn.service.impl;

import com.htn.entity.FileMaster;
import com.htn.exception.GlobalException;
import com.htn.security.custom.CustomUserDetails;
import com.htn.service.FileMasterService;
import com.htn.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FileMasterServiceImpl extends FileAbstract implements FileMasterService {
    @Override
    public FileMaster uploadFile(MultipartFile file) {
        log.info("upload file start");
        List<FileMaster> fileMasterList = handleUploadFiles(List.of(file));
        log.info("upload file done");
        return null;
    }

    @Override
    public List<FileMaster> uploadMultipleFiles(MultipartFile[] files) {
        return List.of();
    }

    @Override
    public Resource fileDownload(String fileName) {
        return null;
    }

    @Override
    public boolean deleteFile(String fileName) {
        return false;
    }

    @Override
    public List<FileMaster> getAllFiles() {
        return List.of();
    }

    public List<FileMaster> handleUploadFiles(List<MultipartFile> files){
        CustomUserDetails userInfo = Utils.getUserDetailsFromSecurityContext();

        List<FileMaster> savedFiles = new ArrayList<>();
        try {
            createDirectory();
            for (MultipartFile file : files) {
                UploadResponseDTO dto = uploadFileStore(file);
                FileMaster fileMaster = modelMapper.map(dto, FileMaster.class);
                savedFiles.add(fileMasterRepository.save(fileMaster));
            }
        } catch (IOException e) {
            log.error("Upload files failed: {}", e.getMessage());
            throw new GlobalException("Upload files failed: " + e.getMessage());
        } catch (Exception e) {
            log.error("Directory creation failed: {}", e.getMessage());
            throw new GlobalException("Directory creation failed: " + e.getMessage());
        }
        return savedFiles;
    }


}
