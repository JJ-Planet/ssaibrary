package com.jjplanet.ssaibrary.api.member.dto;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UpdateMemberDTO {

	//아이디
	private String id;

	//비밀번호
	private String password;
		
	//닉네임
	private String nickname;
	

}
