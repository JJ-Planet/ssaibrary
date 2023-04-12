package com.jjplanet.ssaibrary.api.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * GET 요청
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FindMemberDTO {
	
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
	
	//원본이미지명
	private String originImage;
	
	//저장이미지명
	private String saveImage;


}
