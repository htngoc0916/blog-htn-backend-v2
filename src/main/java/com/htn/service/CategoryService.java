package com.htn.service;

import com.htn.dto.CategoryDTO;
import com.htn.dto.CategorySearchDTO;
import com.htn.dto.PageResponseDTO;
import com.htn.entity.Category;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    //get
    Category getCategory(Long id);
    PageResponseDTO<Category> getAllCategories(Pageable pageable, CategorySearchDTO searchDTO);

    //add
    Category addCategory(CategoryDTO categoryDTO);
    Category updateCategory(Long id, CategoryDTO categoryDTO);

    //delete
    boolean deleteCategory(Long id);
}
