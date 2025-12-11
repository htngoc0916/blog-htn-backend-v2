package com.htn.mapper.mybatis;

import com.htn.dto.CategoryResponseDTO;
import com.htn.dto.CategorySearchDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMbtMapper {

    List<CategoryResponseDTO> searchParentCategories(
            @Param("search") CategorySearchDTO search,
            @Param("offset") int offset,
            @Param("limit") int limit,
            @Param("sort") String sort
    );

    long countParentCategories(@Param("search") CategorySearchDTO search);

    List<CategoryResponseDTO> findChildrenByParentCds(@Param("parentCds") List<String> parentCds);
}
