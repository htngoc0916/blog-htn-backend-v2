package com.htn.service.impl;

import com.htn.dto.CategoryDTO;
import com.htn.dto.CategoryResponseDTO;
import com.htn.dto.CategorySearchDTO;
import com.htn.dto.PageResponseDTO;
import com.htn.entity.Category;
import com.htn.exception.GlobalException;
import com.htn.exception.NotFoundException;
import com.htn.i18n.CommonMessages;
import com.htn.i18n.LocalizationService;
import com.htn.mapper.CategoryMapper;
import com.htn.mapper.mybatis.CategoryMbtMapper;
import com.htn.repository.CategoryRepository;
import com.htn.service.CategoryService;
import com.htn.utils.PagingUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private LocalizationService i18n;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryMbtMapper categoryMbtMapper;

    @Override
    public boolean existsCategoryCd(String categoryCd) {
        return categoryRepository.existsByCategoryCd(categoryCd);
    }

    @Override
    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(
                () -> new NotFoundException(i18n.translate(CommonMessages.COMMON_NOT_FOUND_WITH,"CategoryId=%s"+categoryId))
        );
    }


    @Override
    public PageResponseDTO<CategoryResponseDTO> searchAllCategories(Pageable pageable, CategorySearchDTO searchDTO) {
        PagingUtils.paginationValidate(pageable);

        // build sort string
        String sort = PagingUtils.sortSql(pageable);
        int offset = PagingUtils.offset(pageable);
        int limit = PagingUtils.limit(pageable);

        // 1) Lấy parent theo search + pagination
        List<CategoryResponseDTO> parents = categoryMbtMapper.searchParentCategories(searchDTO, offset, limit, sort);
        long total = categoryMbtMapper.countParentCategories(searchDTO);

        // Nếu không có parent nào thì return luôn
        if (parents.isEmpty()) {
            return PageResponseDTO.of(parents, pageable, total);
        }

        // 2) Lấy danh sách parentCd để load children
        List<String> parentCds = parents.stream().map(CategoryResponseDTO::getCategoryCd).toList();

        // 3) Load children
        List<CategoryResponseDTO> children = categoryMbtMapper.findChildrenByParentCds(parentCds);

        // 4) Gán children cho parent
        Map<String, List<CategoryResponseDTO>> childrenMap = children.stream().collect(Collectors.groupingBy(CategoryResponseDTO::getParentCd));

        for (CategoryResponseDTO parent : parents) {
            parent.setChildren(childrenMap.getOrDefault(parent.getCategoryCd(), new ArrayList<>()));
        }

        return PageResponseDTO.of(parents, pageable, total);
    }

    @Override
    public Category addCategory(CategoryDTO categoryDTO) {
        //check them logic da ton tai
        if(existsCategoryCd(categoryDTO.getCategoryCd())){
            throw new GlobalException(i18n.translate(CommonMessages.COMMON_DATA_EXISTED));
        }

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
        Category category = getCategory(categoryId);
        category.setUsedYn("N");
        categoryRepository.save(category);
        return true;
    }
}
