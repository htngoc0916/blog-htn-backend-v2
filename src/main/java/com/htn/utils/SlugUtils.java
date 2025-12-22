package com.htn.utils;

import lombok.Data;

import java.util.UUID;

@Data
public class SlugUtils {

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
