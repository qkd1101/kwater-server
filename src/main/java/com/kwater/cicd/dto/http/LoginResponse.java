package com.kwater.cicd.dto.http;

import com.kwater.cicd.auth.jwt.Token;
import com.kwater.cicd.domain.user.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginResponse {
    private Long userId;
    private String name;
    private String email;
    private String imageUrl;
    private Role role;
    private Token token;

    @Builder
    public LoginResponse(Long userId, String name, String email, String imageUrl, Role role, Token token) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
        this.role = role;
        this.token = token;
    }
}
