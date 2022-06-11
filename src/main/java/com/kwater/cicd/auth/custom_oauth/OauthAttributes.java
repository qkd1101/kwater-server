package com.kwater.cicd.auth.custom_oauth;

import java.util.Arrays;
import java.util.Map;

public enum OauthAttributes {

    KAKAO("kakao"){
        @Override
        public UserProfile of(Map<String, Object> attributes) {
            String id = String.valueOf(attributes.get("id"));
            Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
            Map<String, Object> kakaoProfile = (Map<String, Object>) kakaoAccount.get("profile");
            return UserProfile.builder()
                    .oauthId(id)
                    .email((String) kakaoAccount.get("email"))
                    .name((String) kakaoProfile.get("nickname"))
                    .imageUrl((String)kakaoProfile.get("profile_image_url"))
                    .build();
        }
    };

    private final String providerName;

    OauthAttributes(String providerName){
        this.providerName = providerName;
    }

    public static UserProfile extract(String providerName, Map<String,Object> attributes){
        return Arrays.stream(values())
                .filter(provider -> providerName.equals(provider.providerName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .of(attributes);
    }

    public abstract UserProfile of(Map<String,Object> attributes);

}
