package com.example.blogAPI.web.dto;

import lombok.Getter;

@Getter
public class CreateAccessTokenResponseDto {
  //0706
  // 리프레시 토큰 받아서 신규 토큰을 받았다면 신규 토큰을 이 dto에 태워서 전송하겠다
  private String accessToken;

  public CreateAccessTokenResponseDto(String accessToken){
    this.accessToken = accessToken;

  }
}
