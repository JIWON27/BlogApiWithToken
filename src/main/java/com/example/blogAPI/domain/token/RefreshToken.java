package com.example.blogAPI.domain.token;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class RefreshToken {
  // 0706
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name="user_id", nullable = false, unique = true)
  private Long userId; // 유저랑 리프레시토큰이랑 매핑해야하니까 생성한 것

  @Column(name="refresh_token", nullable = false)
  private String refreshToken;

  public RefreshToken(Long userId, String refreshToken){
    this.userId = userId;
    this.refreshToken = refreshToken;
  }

  // 이 부분 설명 놓침..그냥 뭔가 리스페시토큰이 만려되었을때랑관련잇는거같음.
  // 이 코드 만든 이유는 강의 듣기.
  public RefreshToken update(String newRefreshToken){
    this.refreshToken = newRefreshToken;
    return this;
  }
}
