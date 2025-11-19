package com.htn.service;

import com.htn.dto.PageResponseDTO;
import com.htn.dto.UserDTO;
import com.htn.dto.UserResponseDTO;
import com.htn.entity.User;
import org.springframework.data.domain.Pageable;

public interface UserService {
    PageResponseDTO<User> getAllUser(Pageable pageable, String categoryName, String usedYn);
    UserResponseDTO getUserInfo(Long id);
    User getUserByEmail(String email);
    boolean existsEmail(String email);
    User addUser(UserDTO userDTO);
    User updateUser(Long userId, UserDTO userDTO);
    void deleteUser(Long userId);
    void deleteAvatar(Long userId);
}
