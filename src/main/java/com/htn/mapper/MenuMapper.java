package com.htn.mapper;

import com.htn.dto.MenuDTO;
import com.htn.dto.MenuResponseDTO;
import com.htn.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MenuMapper {
    Menu toEntity(MenuDTO dto);
    MenuDTO toDto(Menu menu);
    MenuResponseDTO toResponseDto(Menu menu);
    void updateFromDto(MenuDTO dto, @MappingTarget Menu menu);
}
