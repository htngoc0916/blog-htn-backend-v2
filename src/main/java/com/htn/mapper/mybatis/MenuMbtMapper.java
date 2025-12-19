package com.htn.mapper.mybatis;

import com.htn.dto.MenuResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MenuMbtMapper {
    Optional<MenuResponseDTO> getMenuById(Long menuId);
}
