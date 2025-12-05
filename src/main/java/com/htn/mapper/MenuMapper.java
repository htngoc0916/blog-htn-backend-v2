package com.htn.mapper;

import com.htn.dto.MenuDTO;
import com.htn.dto.MenuResponseDTO;
import com.htn.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MenuMapper extends BaseMapper<Menu, MenuDTO> {
    MenuResponseDTO toResponseDto(Menu entity);
}
