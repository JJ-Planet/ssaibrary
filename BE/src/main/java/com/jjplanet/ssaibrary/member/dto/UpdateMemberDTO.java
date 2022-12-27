package com.jjplanet.ssaibrary.member.dto;

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
	
	private String id;
	private String password;
	private String name;
	private String nickname;
	
	//회원정보수정
	@Builder
	public UpdateMemberDTO(String name, String nickname, String password) {
		this.name = name;
		this.nickname = nickname;
		this.password = password;
	}

}
