package com.htn.mapper;

import com.htn.dto.CategoryDTO;
import com.htn.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryDTO> {
}
