package com.htn.mapper;

import com.htn.dto.CategoryDTO;
import com.htn.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "categoryCd", ignore = true)
    void updateFromDto(CategoryDTO dto, @MappingTarget Category entity);
}
