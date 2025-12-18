package com.htn.mapper;

import com.htn.dto.PermissionDTO;
import com.htn.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper extends BaseMapper<Permission, PermissionDTO> {
}
