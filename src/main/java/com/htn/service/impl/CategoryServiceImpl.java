package com.htn.service.impl;

import com.htn.dto.CategoryDTO;
import com.htn.dto.CategorySearchDTO;
import com.htn.dto.PageResponseDTO;
import com.htn.entity.Category;
import com.htn.exception.NotFoundException;
import com.htn.i18n.CommonMessages;
import com.htn.i18n.LocalizationService;
import com.htn.mapper.CategoryMapper;
import com.htn.repository.CategoryRepository;
import com.htn.service.CategoryService;
import com.htn.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private LocalizationService i18n;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public boolean existsCategoryCd(String categoryCd) {
        return categoryRepository.existsByCategoryCd(categoryCd);
    }

    @Override
    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND_WITH, String.format("CategoryId=%s", categoryId)))
        );
    }

    @Override
    public PageResponseDTO<Category> getAllCategories(Pageable pageable, CategorySearchDTO searchDTO) {

        //validation
        Utils.paginationValidate(pageable);

        //check search params
        Page<Category> resultPage;
        if (StringUtils.hasText(searchDTO.getCategoryNm()) && StringUtils.hasText(searchDTO.getUsedYn())) {
            resultPage = categoryRepository.findByCategoryNmContainingAndUsedYn(searchDTO.getCategoryNm(),searchDTO.getUsedYn(), pageable);
        } else if (StringUtils.hasText(searchDTO.getCategoryNm())) {
            resultPage = categoryRepository.findByCategoryNmContaining(searchDTO.getCategoryNm(), pageable);
        } else if (StringUtils.hasText(searchDTO.getUsedYn())) {
            resultPage = categoryRepository.findByUsedYn(searchDTO.getUsedYn(), pageable);
        } else {
            resultPage = categoryRepository.findAll(pageable);
        }

        return PageResponseDTO.of(resultPage);
    }

    @Override
    public Category addCategory(CategoryDTO categoryDTO) {
        //check them logic da ton tai
        Category category = categoryMapper.toEntity(categoryDTO);
        return  categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long categoryId, CategoryDTO categoryDTO) {
        Category category = getCategory(categoryId);

        //update category info
        categoryMapper.updateFromDto(categoryDTO, category);
        return categoryRepository.save(category);
    }

    @Override
    public boolean deleteCategory(Long categoryId) {
        return false;
    }
}
