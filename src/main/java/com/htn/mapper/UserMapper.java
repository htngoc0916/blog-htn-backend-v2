package com.htn.mapper;

import com.htn.dto.UserDTO;
import com.htn.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDTO> {
}
