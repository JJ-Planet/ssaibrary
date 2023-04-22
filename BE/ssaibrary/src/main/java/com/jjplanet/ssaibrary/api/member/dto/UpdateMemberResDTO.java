package com.jjplanet.ssaibrary.api.member.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateMemberResDTO {

    //닉네임
    private String nickname;

    //프사
    private String originImage;

    @Builder
    public UpdateMemberResDTO(String nickname, String originImage){
        this.nickname = nickname;
        this.originImage = originImage;
    }


}
