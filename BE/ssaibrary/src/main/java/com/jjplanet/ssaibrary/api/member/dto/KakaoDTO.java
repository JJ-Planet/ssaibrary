package com.jjplanet.ssaibrary.api.member.dto;

import com.jjplanet.ssaibrary.api.member.domain.Member;
import lombok.*;

import java.sql.Timestamp;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class KakaoDTO {

    //닉네임
    private String nickname;

    //카카오 id
    private String kakaoId;

    //프사
    private String originImage;

    //가입일자
    private Timestamp joinDate;

    //관리자여부
    private char isAdmin;

    //회원상태
    private char status;

    //카카오 로그인
    @Builder
    public KakaoDTO(String nickname, Timestamp joinDate, String kakaoId){
        this.nickname = nickname;
        this.kakaoId = kakaoId;
        this.originImage = "https://ssaibrary.s3.ap-northeast-2.amazonaws.com/profile/default_profile.png";
        this.joinDate = joinDate;
        this.isAdmin = 'N';
        this.status = 'A';
    }

}
