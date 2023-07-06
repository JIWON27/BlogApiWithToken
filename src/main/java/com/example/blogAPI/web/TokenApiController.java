package com.example.blogAPI.web;

import com.example.blogAPI.service.TokenService;
import com.example.blogAPI.web.dto.CreateAccessTokenRequestDto;
import com.example.blogAPI.web.dto.CreateAccessTokenResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TokenApiController {
  // TokenProvider랑 어떤 차이점이이는지 강의 다시 듣기 -> 레이어에 따라 다른거같음...
  // 어렵다.......
  private final TokenService tokenService;

  @PostMapping("/api/latest/token")
  public ResponseEntity<CreateAccessTokenResponseDto> createNewAccessToken
      (@RequestBody CreateAccessTokenRequestDto createAccessTokenRequestDto){
    String newAccessToken = tokenService.createNewAccessToken(createAccessTokenRequestDto.getRefreshToken());

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new CreateAccessTokenResponseDto(newAccessToken));
  }
}
