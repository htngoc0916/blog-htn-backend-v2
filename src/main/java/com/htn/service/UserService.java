package com.htn.service;

import com.htn.dto.UserDTO;
import com.htn.dto.VerifyCodeDTO;
import com.htn.entity.User;

public interface UserService {
    boolean existsEmail(String email);
    boolean verifyCode(VerifyCodeDTO verifyCodeDTO);
    boolean sendVerifyCode(String email);

    //get
    User getUserById(Long userId);
    User getUserByEmail(String email);

    //add
    User addUser(UserDTO userDTO);
    User clientAddUser(UserDTO userDTO);

    //update
    User updateUser(Long id, UserDTO userDTO);

    //delete
    boolean deleteUser(Long id);
}
