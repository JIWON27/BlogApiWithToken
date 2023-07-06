package com.example.blogAPI.service;

import com.example.blogAPI.config.jwt.TokenProvider;
import com.example.blogAPI.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {
  // 전반적으로 token에 관한 서비스 처리

  private final TokenProvider tokenProvider;
  private final RefreshTokenService refreshTokenService;
  private final UserService userService; //userDetailService랑 다른 서비스임


  //AccessToken 신규 발급 메서드
  public String createNewAccessToken(String refreshToken){
    // 토큰 자체에 대한 유효성 검증에 실패하면 예외 q발생
    if (!tokenProvider.validToken(refreshToken)) {
      throw new IllegalArgumentException("unexpected Token");
    }
    Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
    User user = userService.findById(userId);
    return tokenProvider.generateToken(user, Duration.ofHours(2));

  }

  // 최초 유저 인증 또는 접속시 엑세스랑 리프레시 토큰 발행
  // 리프레시 토큰 자체가 만료된 경우
  // 위와 같은 역할을 해주는 관심사를 가지는것을 따로 만드는게 좋을듯?


}
