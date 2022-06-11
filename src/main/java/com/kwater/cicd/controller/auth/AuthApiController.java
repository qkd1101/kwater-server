package com.kwater.cicd.controller.auth;

import com.kwater.cicd.auth.custom_oauth.OauthService;
import com.kwater.cicd.auth.jwt.JwtTokenProvider;
import com.kwater.cicd.auth.jwt.RefreshTokenService;
import com.kwater.cicd.auth.jwt.Token;
import com.kwater.cicd.dto.http.LoginResponse;
import com.kwater.cicd.handler.exception.ErrorCode;
import com.kwater.cicd.handler.exception.TokenTypeMismatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class AuthApiController {

    private final OauthService oauthService;
    private final RefreshTokenService refreshTokenService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping(path = "/login/oauth/{providerName}")
    public ResponseEntity<LoginResponse>  login(@PathVariable String providerName, @RequestParam String accessToken){
        LoginResponse loginResponse = oauthService.login(providerName,accessToken);
        return ResponseEntity.ok().body(loginResponse);
    }

    @GetMapping(path = "/token")
    public Token refreshAccessToken(@RequestHeader Map<String,Object> requestHeader){

        String authHeader = requestHeader.get("x-auth-token").toString();
        if(!authHeader.startsWith("Bearer ")) {
            throw new TokenTypeMismatchException(ErrorCode.TOKEN_TYPE_MISMATCH); //400
        }
        String accessToken = authHeader.substring(7,authHeader.length());
        String userId = jwtTokenProvider.getUserId(accessToken);
        Token token = refreshTokenService.refreshAccessToken(userId);
        return token;
    }

}
