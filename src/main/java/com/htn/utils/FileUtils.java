package com.htn.utils;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class FileUtils {
    //tạo file name với UUID
    public static String generateFileName() {
        String timestamp = String.valueOf(Instant.now().toEpochMilli());
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return String.join("_", timestamp, uuid);
    }
}
