package com.htn.mapper;

import com.htn.dto.CategoryDTO;
import com.htn.dto.UserDTO;
import com.htn.entity.Category;
import com.htn.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryDTO> {
}
