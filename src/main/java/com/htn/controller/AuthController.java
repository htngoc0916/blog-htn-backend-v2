package com.htn.controller;

import com.htn.dto.LoginDTO;
import com.htn.dto.RefreshTokenDTO;
import com.htn.dto.UserDTO;
import com.htn.dto.VerifyCodeDTO;
import com.htn.i18n.AuthMessages;
import com.htn.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController extends BaseController{

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDTO){
        return response(authService.login(loginDTO), AuthMessages.AUTH_LOGIN_SUCCESS);
    }

    @PostMapping(value = "/refresh-token")
    public ResponseEntity<?> refreshToken(@Valid @RequestBody RefreshTokenDTO refreshTokenDTO){
        return response(authService.refreshToken(refreshTokenDTO.getRefreshToken()), AuthMessages.AUTH_REFRESH_TOKEN_SUCCESS);
    }

    @PostMapping(value = "/sign-up")
    public ResponseEntity<?> signup(@Valid @RequestBody UserDTO userDTO){
        return response(authService.signup(userDTO), AuthMessages.AUTH_SIGNUP_SUCCESS);
    }

    @PostMapping(value = "/verification")
    public ResponseEntity<?> verificationCode(@Valid @RequestBody VerifyCodeDTO verifyCodeDTO){
        return response(authService.verifyCode(verifyCodeDTO));
    }

    @PostMapping(value = "/send-verifyCode/{email}")
    public ResponseEntity<?> sendVerifyCode(@PathVariable("email") String email){
        return response(authService.sendVerifyCode(email));
    }
}
