package com.htn.service.impl;

import com.htn.dto.LoginDTO;
import com.htn.dto.UserDTO;
import com.htn.dto.VerifyCodeDTO;
import com.htn.dto.response.AuthResponseDTO;
import com.htn.dto.response.UserResponseDTO;
import com.htn.entity.Role;
import com.htn.entity.Token;
import com.htn.entity.User;
import com.htn.exception.GlobalException;
import com.htn.i18n.AuthMessages;
import com.htn.i18n.LocalizationService;
import com.htn.i18n.UserMessages;
import com.htn.security.custom.CustomUserDetails;
import com.htn.security.jwt.JwtTokenProvider;
import com.htn.service.AuthService;
import com.htn.service.TokenService;
import com.htn.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.htn.utils.SecurityUtil.getUserDetailsFromSecurityContext;

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
    @Autowired
    private LocalizationService i18n;

    @Override
    public AuthResponseDTO login(LoginDTO loginDTO) {
        //xác thực bằng loadUserByUsername
        Authentication authentication = authenticate(loginDTO.getEmail(), loginDTO.getPassword());
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        //lưu thông tin người dùng đã login
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //tạo token
        String token = jwtTokenProvider.generateJwtToken(userDetails);
        Token resultToken = tokenService.addTokenToLogin(token);
        return AuthResponseDTO.builder()
                .accessToken(token)
                .refreshToken(resultToken.getRefreshToken())
                .expiresIn(resultToken.getExpirationDate())
                .refreshExpiresIn(resultToken.getRefreshExpirationDate())
                .build();
    }

    private Authentication authenticate(String userEmail, String password) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userEmail, password);
        try {
            return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        }
        catch(BadCredentialsException ex) {
            //tk or mk khong dung
            throw new GlobalException(HttpStatus.UNAUTHORIZED, i18n.translate(AuthMessages.AUTH_INVALID_CREDENTIALS));
        }
        catch (LockedException ex) {
            //tk bi khoa
            throw new GlobalException(HttpStatus.FORBIDDEN, i18n.translate(UserMessages.USER_BLOCKED));
        }
        catch (DisabledException ex) {
            //tk chua active
            throw new GlobalException(HttpStatus.FORBIDDEN, i18n.translate(UserMessages.USER_EMAIL_NOT_VERIFIED));
        }
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
    public UserResponseDTO register(UserDTO userDTO){
        User user = userService.clientAddUser(userDTO);
        List<String> roles = user.getRoles().stream().map(Role::getRoleCode).toList();
        return UserResponseDTO.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .verifyYn(user.getVerifyYn())
                .usedYn(user.getUsedYn())
                .roles(roles)
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

    @Override
    public UserResponseDTO getMe(){
        CustomUserDetails user = getUserDetailsFromSecurityContext();
        List<String> roles = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        return UserResponseDTO.builder()
                .id(user.getUser().getId())
                .userName(user.getUsername())
                .email(user.getUser().getEmail())
                .verifyYn(user.getUser().getVerifyYn())
                .usedYn(user.getUser().getUsedYn())
                .roles(roles)
                .build();
    }

    @Override
    public String logout(){
        return null;
    }
}
