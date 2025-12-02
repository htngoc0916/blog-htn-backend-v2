package com.htn.service;

import com.htn.dto.CategoryDTO;
import com.htn.dto.PageResponseDTO;
import com.htn.entity.Category;
import org.springframework.data.domain.Pageable;

public interface CategoryServices {
    Category addCategory(CategoryDTO categoryDTO);
    Category getCategory(Long categoryId);
    PageResponseDTO<Category> getAllCategories(Pageable pageable, String categoryName, String usedYn);
    Category updateCategory(CategoryDTO categoryDTO, Long categoryId);
    boolean deleteCategory(Long categoryId);
}
