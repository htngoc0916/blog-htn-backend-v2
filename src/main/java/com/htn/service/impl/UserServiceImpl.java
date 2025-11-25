package com.htn.service.impl;

import com.htn.dto.PageResponseDTO;
import com.htn.dto.UserDTO;
import com.htn.dto.UserResponseDTO;
import com.htn.entity.Role;
import com.htn.entity.User;
import com.htn.exception.GlobalException;
import com.htn.i18n.CommonMessages;
import com.htn.i18n.LocalizationService;
import com.htn.i18n.UserMessages;
import com.htn.repository.RoleRepository;
import com.htn.repository.UserRepository;
import com.htn.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private LocalizationService i18n;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PageResponseDTO<User> getAllUser(Pageable pageable, String categoryName, String usedYn) {
        return null;
    }

    @Override
    public UserResponseDTO getUserInfo(Long id) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public boolean existsEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User addUser(UserDTO userDTO) {
        //check email exists
        if(existsEmail(userDTO.getEmail())){
            throw new GlobalException(i18n.translate(UserMessages.USER_EMAIL_EXISTS));
        }
        //check role exists
        Role role = roleRepository.findByRoleName(userDTO.getRole()).orElseThrow(
                () -> new GlobalException(i18n.translate(CommonMessages.COMMON_NOT_FOUND, userDTO.getRole()))
        );
        //set user info
        User user = modelMapper.map(userDTO, User.class);
        user.setRoles(List.of(role));

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public void deleteAvatar(Long userId) {

    }
}
