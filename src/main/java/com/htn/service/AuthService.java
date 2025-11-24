package com.htn.service;

import com.htn.dto.AuthResponseDTO;
import com.htn.dto.LoginDTO;

public interface AuthService {
    AuthResponseDTO login(LoginDTO loginDTO);
}
