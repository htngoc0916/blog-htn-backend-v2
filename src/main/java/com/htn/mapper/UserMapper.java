package com.htn.mapper;

import com.htn.dto.UserDTO;
import com.htn.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "roles", ignore = true)
    User toEntity(UserDTO dto);

    UserDTO toDto(User user);
    void updateFromDto(UserDTO dto, @MappingTarget User entity);
}
