package com.jjplanet.ssaibrary.member.dto;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class JoinMemberDTO {
	
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String originImage;
	private String saveImage;
	private Date joinDate;
	private char isAdmin;
	private char status;

}
