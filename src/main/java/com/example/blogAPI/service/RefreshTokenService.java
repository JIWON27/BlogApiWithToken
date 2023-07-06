package com.example.blogAPI.service;

import com.example.blogAPI.domain.token.RefreshToken;
import com.example.blogAPI.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
  // / refreshtoken과 관련된 서비스
  private final RefreshTokenRepository refreshTokenRepository;

  // refreshtoken으로 조회
  public RefreshToken findByRefreshToken(String refreshToken){
    return refreshTokenRepository.findByRefreshToken(refreshToken).orElseThrow(
        () -> new IllegalArgumentException("Unexpected Token"));
  }

}
