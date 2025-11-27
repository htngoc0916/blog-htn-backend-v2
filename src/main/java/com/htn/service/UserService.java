package com.htn.service;

import com.htn.dto.UserDTO;
import com.htn.dto.VerifyCodeDTO;
import com.htn.entity.User;

public interface UserService {
    boolean existsEmail(String email);
    User addUser(UserDTO userDTO);
    User clientAddUser(UserDTO userDTO);
    boolean verifyCode(VerifyCodeDTO verifyCodeDTO);
    boolean sendVerifyCode(String email);
}
