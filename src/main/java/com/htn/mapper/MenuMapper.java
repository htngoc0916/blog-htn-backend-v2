package com.htn.mapper;

import com.htn.dto.MenuDTO;
import com.htn.dto.MenuResponseDTO;
import com.htn.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = MenuPermissionConfigMapper.class
)
public interface MenuMapper extends BaseMapper<Menu, MenuDTO> {

    @Mapping(target = "children", ignore = true)
    @Mapping(target = "permissions", source = "permissionConfigs")
    MenuResponseDTO toResponseDto(Menu entity);
}