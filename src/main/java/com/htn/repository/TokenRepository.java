package com.htn.repository;

import com.htn.entity.Token;
import com.htn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    List<Token> findByUserId(Long userId);
    Token findByToken(String token);
    Optional<Token> findByRefreshToken(String refreshToken);
}
