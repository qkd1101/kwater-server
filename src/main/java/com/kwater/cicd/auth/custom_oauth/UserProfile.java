package com.kwater.cicd.auth.custom_oauth;

import com.kwater.cicd.domain.user.Role;
import com.kwater.cicd.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserProfile {
    private final String oauthId;
    private final String name;
    private final String email;
    private final String imageUrl;

    @Builder
    public UserProfile(String oauthId, String name, String email, String imageUrl) {
        this.oauthId = oauthId;
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
    }

    public User toUser(){
        return new User(oauthId,name,email,imageUrl, Role.USER);
    }

}
