package com.htn.service;

import com.htn.dto.CategoryDTO;
import com.htn.dto.CategoryResponseDTO;
import com.htn.dto.CategorySearchDTO;
import com.htn.dto.PageResponseDTO;
import com.htn.entity.Category;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    //get
    Category getCategory(Long id);
    PageResponseDTO<CategoryResponseDTO> searchAllCategories(Pageable pageable, CategorySearchDTO searchDTO);
    boolean existsCategoryCd(String categoryName);

    //add
    Category addCategory(CategoryDTO categoryDTO);
    Category updateCategory(Long id, CategoryDTO categoryDTO);

    //delete
    boolean deleteCategory(Long id);
}
