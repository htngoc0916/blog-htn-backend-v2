package com.htn.mapper;

import com.htn.dto.MenuDTO;
import com.htn.dto.response.MenuResponseDTO;
import com.htn.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = MenuPermissionConfigMapper.class
)
public interface MenuMapper extends BaseMapper<Menu, MenuDTO> {

    @Mapping(target = "children", ignore = true)
    @Mapping(target = "permissions", source = "permissionConfigs")
    MenuResponseDTO toResponseDto(Menu entity);
    List<MenuResponseDTO> toResponseDto(List<Menu> entities);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "permissionConfigs", ignore = true)
    void updateFromDto(MenuDTO dto, @MappingTarget Menu entity);
}