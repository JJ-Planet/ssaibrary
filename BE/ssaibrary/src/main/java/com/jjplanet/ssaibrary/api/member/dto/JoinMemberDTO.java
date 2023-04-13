package com.jjplanet.ssaibrary.api.member.dto;

import java.util.Date;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class JoinMemberDTO {
	
	//아이디(전화번호)
	private String id;
		
	//비밀번호
	private String password;
		
	//이름
	private String name;
		
	//닉네임
	private String nickname;

}
