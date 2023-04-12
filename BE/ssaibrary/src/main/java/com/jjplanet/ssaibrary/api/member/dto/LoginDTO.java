package com.jjplanet.ssaibrary.api.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
	
	//아이디(전화번호)
	private String id;
	
	//비밀번호
	private String password;
	
	//jwt토큰
//	private String refreshToken;
	
	//이름
	private String name;
	
	//닉네임
	private String nickname;
	
	//상태(A:활동상태,X:탈퇴상태)
	private char status;

}
