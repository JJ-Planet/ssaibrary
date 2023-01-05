package com.jjplanet.ssaibrary.member.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	
	//아이디(전화번호)
	private String id;
	
	//비밀번호
	private String password;
	
	//jwt토큰
	private String refreshToken;
	
	//이름
	private String name;
	
	//닉네임
	private String nickname;
	
	//원본이미지명
	private String originImage;
	
	//저장이미지명
	private String saveImage;
	
	//가입일시
	private Date joinDate;
	
	//탈퇴일시
	private Date exitDate; 
	
	//관리자여부(Y:관리자,N:일반회원)
	private char isAdmin;
	
	//상태(A:활동상태,X:탈퇴상태)
	private char status;

}
