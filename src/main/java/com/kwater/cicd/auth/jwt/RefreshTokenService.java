package com.kwater.cicd.auth.jwt;

import com.kwater.cicd.handler.exception.ErrorCode;
import com.kwater.cicd.handler.exception.RefreshTokenNotFoundException;
import com.kwater.cicd.handler.exception.UnAuthorizedRefreshTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    final private RefreshTokenRepository refreshTokenRepository;
    final private JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void save(RefreshToken refreshToken){
        refreshTokenRepository.save(refreshToken);
    }

    @Transactional
    public Token refreshAccessToken(String userId){
        RefreshToken refreshTokenDto = refreshTokenRepository.findById(userId)
                .orElseThrow(() -> new RefreshTokenNotFoundException(ErrorCode.REFRESH_TOKKEN_NOT_FOUND)); //404
        String refreshToken = refreshTokenDto.getRefreshToken();
        if(jwtTokenProvider.validateToken(refreshToken)){
            //JWT 토큰 만들기
            String accessToken = jwtTokenProvider.createAccessToken(userId);
            Token token = Token.builder()
                    .accessToken(accessToken)
                    .accessTokenValidityInMilliseconds(jwtTokenProvider.getAccessTokenValidityInMilliseconds())
                    .refreshToken(refreshToken)
                    .refreshTokenValidityInMilliseconds(jwtTokenProvider.getExpirationDate( refreshToken).getTime() - new Date().getTime())
                    .build();
            return token;
        } else {
            // 리프레시 토큰 만료되면 해당 유저가 재 로그인시 refreshToken 테이블 정보도 업데이트 됨.
            throw new UnAuthorizedRefreshTokenException(ErrorCode.UNAUTHORIZED_REFRESHTOKEN);//401
        }
    }
}
