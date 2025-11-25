package com.htn.service.impl;

import com.htn.dto.AuthResponseDTO;
import com.htn.dto.LoginDTO;
import com.htn.dto.UserDTO;
import com.htn.dto.UserResponseDTO;
import com.htn.entity.Role;
import com.htn.entity.Token;
import com.htn.entity.User;
import com.htn.security.custom.CustomUserDetails;
import com.htn.security.jwt.JwtTokenProvider;
import com.htn.service.AuthService;
import com.htn.service.TokenService;
import com.htn.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserService userService;

    @Override
    public AuthResponseDTO login(LoginDTO loginDTO) {
        //xác thực bằng loadUserByUsername
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        //lưu thông tin người dùng đã login
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //tạo token
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String token = jwtTokenProvider.generateJwtToken(userDetails);
        Token resultToken = tokenService.addTokenToLogin(token);
        return AuthResponseDTO.builder()
                .accessToken(token)
                .refreshToken(resultToken.getRefreshToken())
                .expiresIn(resultToken.getExpirationDate())
                .refreshExpiresIn(resultToken.getRefreshExpirationDate())
                .build();
    }

    @Override
    public AuthResponseDTO refreshToken(String refreshToken) {
        Token resultToken = tokenService.refreshToken(refreshToken);
        return AuthResponseDTO.builder()
                .accessToken(resultToken.getToken())
                .refreshToken(resultToken.getRefreshToken())
                .expiresIn(resultToken.getExpirationDate())
                .refreshExpiresIn(resultToken.getRefreshExpirationDate())
                .build();
    }

    @Override
    public UserResponseDTO signup(UserDTO userDTO){
        User user = userService.addUser(userDTO);
        List<String> roles = user.getRoles().stream().map(Role::getRoleName).toList();
        return UserResponseDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(roles)
                .build();
    }
}
