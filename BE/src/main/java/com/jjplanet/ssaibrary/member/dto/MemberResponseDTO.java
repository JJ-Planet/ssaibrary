package com.jjplanet.ssaibrary.member.dto;

import com.jjplanet.ssaibrary.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * GETø‰√ª
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDTO {
	
	
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String originImage;
	private String saveImage;


}
