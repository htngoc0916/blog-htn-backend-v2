package com.htn.utils;

import com.htn.security.custom.CustomUserDetails;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.Instant;
import java.util.Random;
import java.util.UUID;

public class Utils {
    //tạo mã verify code
    public static String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }

    //tạo file name với UUID
    public static String generateFileName() {
        String timestamp = String.valueOf(Instant.now().toEpochMilli());
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return String.join("_", timestamp, uuid);
    }

    //get thông tin user đã authenticate
    public static CustomUserDetails getUserDetailsFromSecurityContext(){
        CustomUserDetails userDetails = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            userDetails = (CustomUserDetails) authentication.getPrincipal();
        }
        return  userDetails;
    }
}
