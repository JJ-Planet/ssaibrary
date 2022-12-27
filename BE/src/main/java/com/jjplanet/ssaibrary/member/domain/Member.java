package com.jjplanet.ssaibrary.member.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED) //모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본생성자 생성
@Getter //getter 생성
public class Member {


	//아이디(전화번호)
	@Id
	@Column(nullable = false, length = 20)
	private String id;

	//비밀번호
	@Setter
	@Column(nullable = false, length = 255)
	private String password;

	//jwt토큰
	@Column(name = "refresh_token", nullable = true, length = 255)
	private String refreshToken;

	//이름
	@Setter
	@Column(nullable = false, length = 20)
	private String name;

	//닉네임
	@Setter
	@Column(nullable = false, length = 20, unique = true)
	private String nickname;

	//원본이미지명
	@Column(name = "origin_image", nullable = false, length = 255, columnDefinition = "DEFAULT 'default.jpg'")
	private String originImage;

	//저장이미지명
	@Column(name = "save_image", nullable = false, length = 255, columnDefinition = "DEFAULT 'default.jpg'")
	private String saveImage;

	//가입일시
	@Column(name = "join_date", nullable = false, columnDefinition = "DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date joinDate;

	//탈퇴일시
	@Setter
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "exit_date", nullable = true)
	private Date exitDate; 

	//관리자여부(Y:관리자,N:일반회원)
	@Column(name = "is_admin", nullable = false, columnDefinition = "CHAR(1) DEFAULT 'N'")
	private char isAdmin;

	//상태(A:활동상태,X:탈퇴상태)
	@Setter
	@Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'A'")
	private char status;


	//회원가입
	@Builder
	public Member(String id, String password, String name, String nickname, String originImage, String saveImage, Date joinDate, char isAdmin, char status) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.originImage = originImage;
		this.saveImage = saveImage;
		this.joinDate = joinDate;
		this.isAdmin = isAdmin;
		this.status = status;
	}

	//회원정보수정
	@Builder
	public Member(String name, String nickname, String password) {
		this.name = name;
		this.nickname = nickname;
		this.password = password;
	}




}