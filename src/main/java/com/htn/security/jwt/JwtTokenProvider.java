package com.htn.security.jwt;

import com.htn.exception.UnauthorizedException;
import com.htn.security.custom.CustomUserDetails;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;


@Component
@Slf4j
@RequiredArgsConstructor
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expiration-milliseconds}")
    private long jwtExpirationDate;

    public String generateJwtToken(CustomUserDetails userDetail){

        Date curentDate = new Date();
        Date expireDate = new Date(curentDate.getTime() + jwtExpirationDate);

        //tao ra token
        return Jwts.builder()
                .subject(userDetail.getEmail())
//                .claim("id", userDetail.getId())
//                .claim("verifyYN", userDetail.getVerifyYN())
//                .claim("usedYN", userDetail.getUsedYN())
//                .claim("role", userDetail.getAuthorities())
                .issuedAt(curentDate)
                .expiration(expireDate)
                .signWith(key())
                .compact();
    }

    // token key
    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    //get userEmail from jwt token
    public String getUserEmail(String token) {
        Claims claims = Jwts
                .parser()
                .verifyWith((SecretKey) key())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    //validate Jwt token
    public boolean validateToken(String token){
        try {
            Jwts.parser().verifyWith((SecretKey) key()).build().parse(token);
            return true;
        }catch (MalformedJwtException ex){
            log.error("Invalid JWT token: {}", ex.getMessage());
            throw new UnauthorizedException("Invalid JWT token");
        }catch (ExpiredJwtException ex){
            log.error("Expired JWT token: {}", ex.getMessage());
            throw new UnauthorizedException("Expired JWT token");
        }catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token: {}", ex.getMessage());
            throw new UnauthorizedException("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty: {}", ex.getMessage());
            throw new UnauthorizedException("JWT claims string is empty");
        }
    }
}
