package com.htn.service.impl;

import com.htn.dto.CategoryDTO;
import com.htn.dto.PageResponseDTO;
import com.htn.entity.Category;
import com.htn.repository.CategoryRepository;
import com.htn.service.CategoryServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryServices {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(CategoryDTO categoryDTO) {

        return null;
    }

    @Override
    public Category getCategory(Long categoryId) {
        return null;
    }

    @Override
    public PageResponseDTO<Category> getAllCategories(Pageable pageable, String categoryName, String usedYn) {
        return null;
    }

    @Override
    public Category updateCategory(CategoryDTO categoryDTO, Long categoryId) {
        return null;
    }

    @Override
    public boolean deleteCategory(Long categoryId) {
        return false;
    }
}
