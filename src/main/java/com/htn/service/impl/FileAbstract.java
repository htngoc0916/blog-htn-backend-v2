package com.htn.service.impl;

import com.htn.dto.UploadResponseDTO;
import com.htn.exception.GlobalException;
import com.htn.i18n.FileMessages;
import com.htn.i18n.LocalizationService;
import com.htn.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public abstract class FileAbstract {
    @Value("${file.upload-path}")
    private String uploadPath;
    private String savePath;

    @Autowired
    private LocalizationService i18n;

    public FileAbstract() {
        this.savePath = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    //tạo thư mục
    public void createDirectory() throws Exception{
        Path path = Paths.get(uploadPath).resolve(savePath).normalize();
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }

    //lấy đuôi file
    private String getExtension(String fileName) {
        if (fileName == null || !fileName.contains(".")) return "";
        return fileName.substring(fileName.lastIndexOf("."));
    }

    //upload
    public UploadResponseDTO uploadFileStore(MultipartFile file) throws IOException {
        String originalName = file.getOriginalFilename();
        String extension = getExtension(originalName);
        String fileName = Utils.generateFileName().concat(extension);

        //copyfile
        Path path = Paths.get(uploadPath).resolve(savePath).resolve(fileName).normalize();
        Files.copy(file.getInputStream(), path);

        return UploadResponseDTO.builder()
                .filePath(savePath)
                .fileName(fileName)
                .fileOriginalName(originalName)
                .fileType(extension)
                .fileSize(file.getSize())
                .build();
    }

    //download
    public Resource downloadFileStore(String filePath) throws IOException {
        Path file = Paths.get(uploadPath).resolve(filePath).normalize();
        Resource resource = new UrlResource(file.toUri());
        if (resource.exists() || resource.isReadable()) {
            return resource;
        } else {
            throw new GlobalException(i18n.translate(FileMessages.FILE_DOWNLOAD_FAIL, filePath));
        }
    }

    //delete
    public void deleteFileStore(String filePath) throws IOException {
        Path file = Paths.get(uploadPath).resolve(filePath).normalize();
        Files.deleteIfExists(file);
    }
}
