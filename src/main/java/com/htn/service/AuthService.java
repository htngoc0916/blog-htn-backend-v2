package com.htn.service;

import com.htn.dto.*;

public interface AuthService {
    AuthResponseDTO login(LoginDTO loginDTO);
    AuthResponseDTO refreshToken(String refreshToken);
    UserResponseDTO signup(UserDTO userDTO);
}
