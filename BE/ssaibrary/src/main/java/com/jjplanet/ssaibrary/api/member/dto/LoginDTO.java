package com.jjplanet.ssaibrary.api.member.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class LoginDTO {

    // 아이디(전화번호)
    private String id;

    // access token
    private String accessToken;

    // refresh toekn
    private String refreshToken;

    // 이름
    private String name;

    // 닉네임
    private String nickname;

    // 프사
    private String originImage;

    @Builder
    public LoginDTO(String id, String accessToken, String refreshToken, String name, String nickname, String originImage) {
        this.id = id;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.name = name;
        this.nickname = nickname;
        this.originImage = originImage;
    }


}
