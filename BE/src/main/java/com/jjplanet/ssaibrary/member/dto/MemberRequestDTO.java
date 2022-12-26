package com.jjplanet.ssaibrary.member.dto;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * POST, PUT요청
 */

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRequestDTO {

	private String id;
	private String password;
	//private String refreshToken;
	private String name;
	private String nickname;
	private String originImage;
	private String saveImage;
	private Date joinDate;
	//private Date exitDate;
	private char isAdmin;
	private char status;


	//회원정보수정
	@Builder
	public MemberRequestDTO(String name, String nickname, String password) {
		this.name = name;
		this.nickname = nickname;
		this.password = password;
	}

//	//진짜회원삭제
//	@Builder
//	public MemberRequestDTO(Date exitDate, char status) {
//		this.exitDate = exitDate;
//		this.status = status;
//	}

//	@Override
//	public String toString() {
//		return "MemberRequestDTO [id=" + id + ", password=" + password + ", refreshToken=" + refreshToken + ", name="
//				+ name + ", nickname=" + nickname + ", originImage=" + originImage + ", saveImage=" + saveImage
//				+ ", joinDate=" + joinDate + ", exitDate=" + exitDate + ", isAdmin=" + isAdmin + ", status=" + status
//				+ "]";
//	}


}