package com.htn.service.impl;

import com.htn.dto.FileUploadDTO;
import com.htn.dto.UploadResponseDTO;
import com.htn.exception.GlobalException;
import com.htn.i18n.FileMessages;
import com.htn.i18n.LocalizationService;
import com.htn.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@Slf4j
public abstract class FileAbstract {
    @Value("${file.upload-path}")
    private String uploadPath;
    private String savePath;

    @Autowired
    private LocalizationService i18n;

    public FileAbstract() {
        this.savePath = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM"));
    }

    //tạo thư mục
    public void createDirectory() throws Exception{
        try {
            Path path = Paths.get(uploadPath).resolve(savePath).normalize();
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
        } catch (Exception e){
            log.error("Directory creation failed: {}", e.getMessage());
            throw new GlobalException(i18n.translate(FileMessages.FILE_DIRECTORY_CREATION_FAIL));
        }
    }

    //lấy đuôi file
    private String getExtension(String fileName) {
        if (fileName == null || !fileName.contains(".")) return "";
        return fileName.substring(fileName.lastIndexOf("."));
    }

    //upload
    public UploadResponseDTO uploadFileStore(FileUploadDTO fileUploadDTO) throws IOException {
        //get file
        MultipartFile file = fileUploadDTO.getFile();

        //setting file name
        String originalName = file.getOriginalFilename();
        String extension = getExtension(originalName);
        String fileName = Utils.generateFileName().concat(extension);

        //check is video or images
        String contentType = file.getContentType();
        boolean isImage = contentType != null && contentType.startsWith("image/");
        boolean isVideo = contentType != null && contentType.startsWith("video/");

        Integer width = null;
        Integer height = null;
        Float duration = null;
        
        //copyfile
        Path path = Paths.get(uploadPath).resolve(savePath).resolve(fileName).normalize();
        Files.copy(file.getInputStream(), path);

        // xử lý metadata
        if (isImage) {
            BufferedImage image = ImageIO.read(path.toFile());
            if (image != null) {
                width = image.getWidth();
                height = image.getHeight();
            }
        }else if (isVideo) {
            duration = getVideoDuration(path);
        }

       return UploadResponseDTO.builder()
                .fileTitle(fileUploadDTO.getFileTitle())
                .filePath(savePath)
                .fileName(fileName)
                .fileNameOrg(originalName)
                .fileType(extension)
                .fileSize(file.getSize())
                .mediaType(isImage ? "IMAGE" : isVideo ? "VIDEO" : "FILE")
                .width(width)
                .height(height)
                .duration(duration)
                .build();
    }

    private Float getVideoDuration(Path videoPath) {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "ffprobe",
                    "-v", "error",
                    "-show_entries", "format=duration",
                    "-of", "default=noprint_wrappers=1:nokey=1",
                    videoPath.toString()
            );
            Process process = pb.start();

            try (var reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()))) {
                String line = reader.readLine();
                return line != null ? Float.parseFloat(line) : null;
            }
        } catch (Exception e) {
            log.error("Cannot get video duration", e);
            throw new GlobalException(i18n.translate(FileMessages.FILE_CAN_NOT_GET_DURATION));
        }
    }

    //download
    public Resource downloadFileStore(String filePath) throws IOException {
        Path path = Paths.get(uploadPath).toAbsolutePath().normalize().resolve(filePath);
        Resource resource = new UrlResource(path.toUri());
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
