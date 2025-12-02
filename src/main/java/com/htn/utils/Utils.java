package com.htn.utils;

import com.htn.constant.CommonConstant;
import com.htn.exception.GlobalException;
import com.htn.security.custom.CustomUserDetails;
import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.Instant;
import java.util.Random;
import java.util.UUID;

@Data
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

    //validation pageSize
    public static void paginationValidate(Pageable pageable){
        int page = pageable.getPageNumber();
        int size = pageable.getPageSize();

        if (page < 0) {
            throw new GlobalException("Page number cannot be less than 0");
        }

        if (size < 0) {
            throw new GlobalException("Size number cannot be less than 0");
        }

        if (size > CommonConstant.MAX_AUTH_TOKEN) {
            throw new GlobalException("Page size must not be greater than " + CommonConstant.MAX_AUTH_TOKEN);
        }
    }
}
