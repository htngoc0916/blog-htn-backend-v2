package com.htn.mapper;

import com.htn.dto.RoleDTO;
import com.htn.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<Role, RoleDTO>{

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roleCode", ignore = true)
    void updateFromDto(RoleDTO dto, @MappingTarget Role entity);
}
