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
    public static CustomUserDetails getUserDetailsFromSecurityContext() {
        CustomUserDetails userDetails = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            userDetails = (CustomUserDetails) authentication.getPrincipal();
        }
        return userDetails;
    }

//    //validation pageSize
//    public static void paginationValidate(Pageable pageable) {
//        int page = pageable.getPageNumber();
//        int size = pageable.getPageSize();
//
//        if (page < 0) {
//            throw new GlobalException("Page number cannot be less than 0");
//        }
//
//        if (size < 0) {
//            throw new GlobalException("Size number cannot be less than 0");
//        }
//
//        if (size > CommonConstant.MAX_PAGE_SIZE) {
//            throw new GlobalException("Page size must not be greater than " + CommonConstant.MAX_PAGE_SIZE);
//        }
//    }

    //get current user id
    public static Long getCurrentUserId() {
        CustomUserDetails user = getUserDetailsFromSecurityContext();
        return (user != null) ? user.getId() : null;
    }

    //generate slug to string
    public static String generateSlug(String input) {
        if (input == null || input.isBlank()) return "";

        // Convert to lower case
        String slug = input.toLowerCase();

        // Remove accents (Vietnamese, Korean, etc.)
        slug = java.text.Normalizer.normalize(slug, java.text.Normalizer.Form.NFD);
        slug = slug.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        // Replace non-alphanumeric with "-"
        slug = slug.replaceAll("[^a-z0-9]+", "-");

        // Remove leading/trailing "-"
        slug = slug.replaceAll("(^-|-$)", "");

        return slug;
    }

    // Thêm hậu tố 6 ký tự ngẫu nhiên
    public static String appendSlugSuffix(String slug) {
        String random = UUID.randomUUID().toString().substring(0, 6);
        return slug + "-" + random;
    }

    /**
     * Đảm bảo slug unique bằng cách kiểm tra DB qua callback
     *
     * @param baseSlug slug gốc
     * @param existsChecker hàm callback kiểm tra slug đã tồn tại
     * @return slug unique
     */
    public static String toUniqueSlug(String baseSlug, java.util.function.Predicate<String> existsChecker) {
        String slug = baseSlug;

        while (existsChecker.test(slug)) {
            // Nếu tồn tại trong DB
            slug = appendSlugSuffix(baseSlug);
        }

        return slug;
    }
}
