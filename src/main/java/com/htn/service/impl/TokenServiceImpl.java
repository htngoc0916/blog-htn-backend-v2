package com.htn.service.impl;

import com.htn.entity.Token;
import com.htn.entity.User;
import com.htn.exception.UnauthorizedException;
import com.htn.i18n.AuthMessages;
import com.htn.i18n.LocalizationService;
import com.htn.repository.TokenRepository;
import com.htn.repository.UserRepository;
import com.htn.security.custom.CustomUserDetails;
import com.htn.security.jwt.JwtTokenProvider;
import com.htn.service.TokenService;
import com.htn.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
        CustomUserDetails userDetails = Utils.getUserDetailsFromSecurityContext();
        if(userDetails == null){
            throw new UnauthorizedException(i18n.translate(AuthMessages.AUTH_INVALID_CREDENTIALS));
        }

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
    @Override
    public Token refreshToken(String refreshToken){
        Token token = tokenRepository.findByRefreshToken(refreshToken).orElseThrow(
                () -> new UnauthorizedException(i18n.translate(AuthMessages.AUTH_TOKEN_EXPIRED))
        );
        if(token.getRefreshExpirationDate().before(new Date())){
            throw new UnauthorizedException(i18n.translate(AuthMessages.AUTH_TOKEN_EXPIRED));
        }

        //đang làm tới đây
        User user = userRepository.findById(token.getUserId()).orElseThrow(
                () -> new UnauthorizedException(i18n.translate(AuthMessages.AUTH_TOKEN_EXPIRED))
        );

        //tạo ra refresh token và access token mới
        CustomUserDetails customUserDetails = CustomUserDetails.build(user);
        String newToken = jwtTokenProvider.generateJwtToken(customUserDetails);
        Date curentDate = new Date();
        Date expirationDateTime = new Date(curentDate.getTime() + expiration);
        Date refreshExpirationDateTime = new Date(curentDate.getTime() + refreshExpiration);

        token.setToken(newToken);
        token.setExpirationDate(expirationDateTime);
        token.setRefreshToken(UUID.randomUUID().toString());
        token.setRefreshExpirationDate(refreshExpirationDateTime);

        return tokenRepository.save(token);
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
}
