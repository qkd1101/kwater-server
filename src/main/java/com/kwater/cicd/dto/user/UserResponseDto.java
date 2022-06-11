package com.kwater.cicd.dto.user;

import com.kwater.cicd.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserResponseDto {
    private Long userId;

    private String name;

    private String email;

    private String imageUrl;


    public UserResponseDto(User entity){
        this.userId = entity.getUserId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.imageUrl = entity.getImageUrl();
    }
}
