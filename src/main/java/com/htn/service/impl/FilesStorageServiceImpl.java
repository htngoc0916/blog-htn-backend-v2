package com.htn.service.impl;

import com.htn.dto.FileUploadDTO;
import com.htn.dto.FileUploadMultipleDTO;
import com.htn.dto.UploadResponseDTO;
import com.htn.entity.FileMaster;
import com.htn.exception.GlobalException;
import com.htn.i18n.FileMessages;
import com.htn.i18n.LocalizationService;
import com.htn.mapper.FileMasterMapper;
import com.htn.repository.FileMasterRepository;
import com.htn.security.custom.CustomUserDetails;
import com.htn.service.FilesStorageService;
import com.htn.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FilesStorageServiceImpl extends FileAbstract implements FilesStorageService {

    @Autowired
    private FileMasterMapper mapper;
    @Autowired
    private FileMasterRepository fileMasterRepository;
    @Autowired
    private LocalizationService i18n;

    @Override
    public FileMaster getFileById(Long fileId) {
        return fileMasterRepository.findById(fileId).orElseThrow(
                () -> new GlobalException(i18n.translate(FileMessages.FILE_NOT_FOUND, fileId))
        );
    }
    @Override
    public FileMaster findByFileName(String fileName) {
        return fileMasterRepository.findByFileName(fileName).orElseThrow(
                () -> new GlobalException(i18n.translate(FileMessages.FILE_NOT_FOUND, fileName))
        );
    }

    //Upload 1 file
    @Override
    public FileMaster uploadFile(FileUploadDTO file) {
        try {
            log.info("upload file start");
            //tao thu muc
            createDirectory();

            //lay thong tin user
            CustomUserDetails userInfo = Utils.getUserDetailsFromSecurityContext();
            file.setRegId(userInfo.getId());

            //upload file
            FileMaster saved = handleUpload(file);
            log.info("upload file end");
            return saved;
        }
        catch (Exception e){
            log.error("Upload file failed: {}", e.getMessage());
            throw new GlobalException(i18n.translate(FileMessages.FILE_UPLOAD_FAIL));
        }
    }

    //Upload nhiều file
    @Override
    public List<FileMaster> uploadMultipleFiles(FileUploadMultipleDTO fileUploadMultipleDTO) {
       try {
           log.info("upload multiple files start");
           //tao thu muc
           createDirectory();

           //lay thong tin user
           CustomUserDetails userInfo = Utils.getUserDetailsFromSecurityContext();
           fileUploadMultipleDTO.setRegId(userInfo.getId());

           //upload file
           List<FileMaster> result = new ArrayList<>();
           MultipartFile[] files = fileUploadMultipleDTO.getFile();
           String[] titles = fileUploadMultipleDTO.getFileTitle();

           //lặp qua từng file
           for (int i = 0; i < files.length; i++) {
               //set thông tin cho file
               FileUploadDTO fileUploadDTO = FileUploadDTO.builder()
                       .file(files[i])
                       .fileTitle(titles.length > i ? titles[i] : null)
                       .regId(userInfo.getId())
                       .build();

               // Upload từng file
               FileMaster saved = handleUpload(fileUploadDTO);
               result.add(saved);
           }
           return result;
       }catch (Exception e){
           log.error("Upload files failed: {}", e.getMessage());
           throw new GlobalException(i18n.translate(FileMessages.FILE_UPLOAD_FAIL));
       }
    }

    @Override
    public Resource fileDownload(String fileName){
        try {
            FileMaster fileMaster = findByFileName(fileName);
            String path = fileMaster.getFilePath().concat("/").concat(fileName);
            return downloadFileStore(path);
        }catch (Exception e){
            log.error("Download file failed: {}", e.getMessage());
            throw new GlobalException(i18n.translate(FileMessages.FILE_DOWNLOAD_FAIL));
        }
    }

    @Override
    public boolean deleteFile(String fileName) {
        try {
            FileMaster fileMaster = findByFileName(fileName);
            String path = fileMaster.getFilePath().concat("/").concat(fileName);
            deleteFileStore(path);
            fileMasterRepository.delete(fileMaster);
            return true;
        }catch (Exception e){
            log.error("Delete file failed: {}", e.getMessage());
            return false;
        }
    }

    //handle upload file
    private FileMaster handleUpload(FileUploadDTO file) throws IOException {
        UploadResponseDTO rs = uploadFileStore(file);
        FileMaster entity = mapper.toEntity(rs);
        return fileMasterRepository.save(entity);
    }
}
