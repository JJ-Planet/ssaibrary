package com.jjplanet.ssaibrary.api.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginReqDTO {

    //아이디(전화번호)
    private String id;

    //비밀번호
    private String password;

}
