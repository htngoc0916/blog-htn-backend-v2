package com.htn.service.impl;

import com.htn.entity.Token;
import com.htn.exception.UnauthorizedException;
import com.htn.i18n.AuthMessages;
import com.htn.i18n.LocalizationService;
import com.htn.repository.TokenRepository;
import com.htn.repository.UserRepository;
import com.htn.security.custom.CustomUserDetails;
import com.htn.security.jwt.JwtTokenProvider;
import com.htn.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    @Autowired
    LocalizationService i18n;
    @Autowired
    HttpServletRequest request;
    @Autowired
    TokenRepository tokenRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Value("${jwt.expiration-milliseconds}")
    private Long expiration;
    @Value("${jwt.refresh-expiration-milliseconds}")
    private Long refreshExpiration;

    @Override
    @Transactional
    public Token addTokenToLogin(String token) {
        //lấy thông tin device
        String device = request.getHeader("User-Agent");
        String deviceType = detectDevice(device);

        // Lấy user đã authenticate
        CustomUserDetails userDetails = getUserDetailsFromSecurityContext();

        Date curentDate = new Date();
        Date expirationDateTime = new Date(curentDate.getTime() + expiration);
        Date refreshExpirationDateTime = new Date(curentDate.getTime() + refreshExpiration);
        return tokenRepository.save(Token.builder()
                            .token(token)
                            .tokenType("Bearer")
                            .expirationDate(expirationDateTime)
                            .refreshToken(UUID.randomUUID().toString())
                            .refreshExpirationDate(refreshExpirationDateTime)
                            .device(device)
                            .deviceType(deviceType)
                            .userId(userDetails.getId())
                            .build());
    }

    //kiểm tra xem đăng nhập trên MB/PC
    public String detectDevice(String userAgent) {
        if (userAgent == null) return null;

        String ua = userAgent.toLowerCase();
        if (ua.contains("mobi")
                || ua.contains("android")
                || ua.contains("iphone")
                || ua.contains("ipad")
                || ua.contains("tablet")) {
            return "M";
        }
        return "P";
    }

    private CustomUserDetails getUserDetailsFromSecurityContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
            return (CustomUserDetails) authentication.getPrincipal();
        } else {
            throw new UnauthorizedException(i18n.translate(AuthMessages.AUTH_INVALID_CREDENTIALS));
        }
    }
}
