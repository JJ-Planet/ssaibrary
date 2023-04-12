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
	
	//아이디(전화번호)
	private String id;
		
	//비밀번호
	private String password;
		
	//이름
	private String name;
		
	//닉네임
	private String nickname;
		
	//원본이미지명
	private String originImage;
		
	//저장이미지명
	private String saveImage;
	

}
