package com.example.blogAPI.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccessTokenRequestDto {
  //0706 생성
  // 토큰을 신규로 만들려면 리프레시 토큰을 받아야함
  private String refreshToken;


}
