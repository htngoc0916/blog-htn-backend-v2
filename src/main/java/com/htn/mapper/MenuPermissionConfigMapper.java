package com.htn.mapper;

import com.htn.dto.PermissionConfigDTO;
import com.htn.entity.MenuPermissionConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MenuPermissionConfigMapper {
    @Mapping(target = "permissionCd", source = "permission.permissionCd")
    @Mapping(target = "permissionName", source = "permission.permissionNm")
    PermissionConfigDTO toDto(MenuPermissionConfig entity);
}
