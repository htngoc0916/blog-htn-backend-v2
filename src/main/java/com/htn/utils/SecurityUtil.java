package com.htn.utils;

import com.htn.security.custom.CustomUserDetails;
import lombok.Data;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Random;

@Data
public class SecurityUtil {
    //tạo mã verify code
    public static String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }

    //get thông tin user đã authenticate
    public static CustomUserDetails getUserDetailsFromSecurityContext() {
        CustomUserDetails userDetails = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            userDetails = (CustomUserDetails) authentication.getPrincipal();
        }
        return userDetails;
    }

    //get current user id
    public static Long getCurrentUserId() {
        CustomUserDetails user = getUserDetailsFromSecurityContext();
        return (user != null) ? user.getId() : null;
    }
}
