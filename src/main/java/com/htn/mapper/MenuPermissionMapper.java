package com.htn.mapper;

import com.htn.dto.PermissionConfigDTO;
import com.htn.entity.MenuPermission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MenuPermissionMapper {
    @Mapping(target = "permissionCd", source = "permission.permissionCd")
    @Mapping(target = "permissionName", source = "permission.permissionNm")
    PermissionConfigDTO toDto(MenuPermission entity);
}
