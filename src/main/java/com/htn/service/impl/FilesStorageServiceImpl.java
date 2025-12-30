package com.htn.service.impl;

import com.htn.dto.FileUploadDTO;
import com.htn.dto.FileUploadMultipleDTO;
import com.htn.dto.response.UploadResponseDTO;
import com.htn.entity.MediaMaster;
import com.htn.exception.GlobalException;
import com.htn.i18n.FileMessages;
import com.htn.i18n.LocalizationService;
import com.htn.mapper.MediaMasterMapper;
import com.htn.module.FileModule;
import com.htn.repository.MediaMasterRepository;
import com.htn.service.FilesStorageService;
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
public class FilesStorageServiceImpl extends FileModule implements FilesStorageService {

    @Autowired
    private MediaMasterMapper mapper;
    @Autowired
    private MediaMasterRepository MediaMasterRepository;
    @Autowired
    private LocalizationService i18n;

    @Override
    public MediaMaster getFileById(Long fileId) {
        return MediaMasterRepository.findById(fileId).orElseThrow(
                () -> new GlobalException(i18n.translate(FileMessages.FILE_NOT_FOUND, fileId))
        );
    }
    @Override
    public MediaMaster findByFileName(String fileName) {
        return MediaMasterRepository.findByFileName(fileName).orElseThrow(
                () -> new GlobalException(i18n.translate(FileMessages.FILE_NOT_FOUND, fileName))
        );
    }

    //Upload 1 file
    @Override
    public MediaMaster uploadFile(FileUploadDTO file) {
        try {
            log.info("upload file start");
            //tao thu muc
            createDirectory();

            //upload file
            MediaMaster saved = handleUpload(file);
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
    public List<MediaMaster> uploadMultipleFiles(FileUploadMultipleDTO fileUploadMultipleDTO) {
       try {
           log.info("upload multiple files start");
           //tao thu muc
           createDirectory();

           //upload file
           List<MediaMaster> result = new ArrayList<>();
           MultipartFile[] files = fileUploadMultipleDTO.getFile();
           String[] titles = fileUploadMultipleDTO.getFileTitle();

           //lặp qua từng file
           for (int i = 0; i < files.length; i++) {
               //set thông tin cho file
               FileUploadDTO fileUploadDTO = FileUploadDTO.builder()
                       .file(files[i])
                       .fileTitle(titles.length > i ? titles[i] : null)
                       .build();

               // Upload từng file
               MediaMaster saved = handleUpload(fileUploadDTO);
               result.add(saved);
           }
           log.info("upload multiple file end");
           return result;
       }catch (Exception e){
           log.error("Upload files failed: {}", e.getMessage());
           throw new GlobalException(i18n.translate(FileMessages.FILE_UPLOAD_FAIL));
       }
    }

    @Override
    public Resource fileDownload(String fileName){
        try {
            MediaMaster MediaMaster = findByFileName(fileName);
            String path = MediaMaster.getFilePath().concat("/").concat(fileName);
            return downloadFileStore(path);
        }catch (Exception e){
            log.error("Download file failed: {}", e.getMessage());
            throw new GlobalException(i18n.translate(FileMessages.FILE_DOWNLOAD_FAIL));
        }
    }

    @Override
    public boolean deleteFile(String fileName) {
        try {
            MediaMaster MediaMaster = findByFileName(fileName);
            String path = MediaMaster.getFilePath().concat("/").concat(fileName);
            deleteFileStore(path);
            MediaMasterRepository.delete(MediaMaster);
            return true;
        }catch (Exception e){
            log.error("Delete file failed: {}", e.getMessage());
            return false;
        }
    }

    //handle upload file
    private MediaMaster handleUpload(FileUploadDTO file) throws IOException {
        UploadResponseDTO rs = uploadFileStore(file);
        MediaMaster entity = mapper.uploadResponseToEntity(rs);
        return MediaMasterRepository.save(entity);
    }
}
