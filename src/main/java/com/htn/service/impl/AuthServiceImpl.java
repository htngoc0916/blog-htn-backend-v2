package com.htn.service.impl;

import com.htn.dto.*;
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
        User user = userService.clientAddUser(userDTO);
        List<String> roles = user.getRoles().stream().map(Role::getRoleName).toList();
        return UserResponseDTO.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .verifyYn(user.getVerifyYn())
                .usedYn(user.getUsedYn())
                .role(roles)
                .build();
    }

    @Override
    public boolean verifyCode(VerifyCodeDTO verifyCodeDTO) {
        return userService.verifyCode(verifyCodeDTO);
    }

    @Override
    public boolean sendVerifyCode(String email) {
        return userService.sendVerifyCode(email);
    }
}
