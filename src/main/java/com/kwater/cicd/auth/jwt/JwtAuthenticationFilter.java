package com.kwater.cicd.auth.jwt;

import com.kwater.cicd.handler.exception.ErrorCode;
import com.kwater.cicd.handler.exception.TokenTypeMismatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String authHeader = jwtTokenProvider.resolveToken((HttpServletRequest) request);
        if (authHeader != null ) {   // token 검증
            if (authHeader.startsWith("Bearer ")){ // 토큰 타입 Bearer 인증 -> NULL_AUTHENTICATION
                String token = authHeader.substring(7, authHeader.length());
                if(jwtTokenProvider.validateToken(token)) { // 토큰 유효한지 인증 -> NULL_AUTHENTICATION
                    Authentication authentication = jwtTokenProvider.getAuthentication(token);    // 인증 객체 생성
                    SecurityContextHolder.getContext().setAuthentication(authentication); // SecurityContextHolder에 인증 객체 저장
                }
            }
        }
        chain.doFilter(request,response);

    }
}
