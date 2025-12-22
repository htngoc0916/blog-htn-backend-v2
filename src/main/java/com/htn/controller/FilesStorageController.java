package com.htn.controller;

import com.htn.dto.FileUploadDTO;
import com.htn.dto.FileUploadMultipleDTO;
import com.htn.service.FilesStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/files")
@Slf4j
public class FilesStorageController extends BaseController {
    @Autowired
    FilesStorageService fileMasterService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFile(@ModelAttribute FileUploadDTO file){
        return response(fileMasterService.uploadFile(file));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/batch", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadMultipleFiles(@ModelAttribute FileUploadMultipleDTO files){
        return response(fileMasterService.uploadMultipleFiles(files));
    }

    @GetMapping("/{fileName:.+}")
    public ResponseEntity<?> downloadFile(@PathVariable String fileName) {
//        Resource file = fileMasterService.fileDownload(fileName);
//
//        // Lấy content type (nếu không xác định được thì dùng default)
//        String contentType = "application/octet-stream";
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                // Dòng này QUAN TRỌNG để client tính toán %:
//                .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.contentLength()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
//                .body(file);
        return response(fileMasterService.fileDownload(fileName));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getFileById(@PathVariable Long id) {
        return response(fileMasterService.getFileById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{fileName}")
    public ResponseEntity<?> deleteFile(@PathVariable String fileName) {
        return response(fileMasterService.deleteFile(fileName));
    }
}
