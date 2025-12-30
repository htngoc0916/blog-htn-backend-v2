package com.htn.service;

import com.htn.dto.*;
import com.htn.dto.response.AuthResponseDTO;
import com.htn.dto.response.UserResponseDTO;

public interface AuthService {
    AuthResponseDTO login(LoginDTO loginDTO);
    AuthResponseDTO refreshToken(String refreshToken);
    UserResponseDTO signup(UserDTO userDTO);
    boolean verifyCode(VerifyCodeDTO verifyCodeDTO);
    boolean sendVerifyCode(String email);
}
