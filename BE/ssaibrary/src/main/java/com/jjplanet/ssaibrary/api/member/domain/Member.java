package com.jjplanet.ssaibrary.api.member.domain;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jjplanet.ssaibrary.api.member.dto.DeleteMemberDTO;
import com.jjplanet.ssaibrary.api.member.dto.JoinMemberDTO;
import com.jjplanet.ssaibrary.api.member.dto.LoginDTO;
import com.jjplanet.ssaibrary.api.member.dto.MemberDTO;
import com.jjplanet.ssaibrary.api.member.dto.UpdateMemberDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED) //모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본생성자 생성
@Getter //getter 생성
public class Member implements Serializable{


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
	public Member(JoinMemberDTO joinMemberDTO, Timestamp currentTimestamp) {
		this.id = joinMemberDTO.getId();
		this.password = joinMemberDTO.getPassword();
		this.name = joinMemberDTO.getName();
		this.nickname = joinMemberDTO.getNickname();
		this.originImage = "https://ssaibrary.s3.ap-northeast-2.amazonaws.com/profile/default_profile.png";
		this.saveImage = "default";
		this.joinDate = currentTimestamp;
		this.isAdmin = 'N';
		this.status = 'A';
	}
	
	//Account List
//	public static MemberDTO toDTOWithMember(Member member) {
//		return new MemberDTO(member.getId(), member.getPassword(), member.getRefreshToken(), member.getName(), member.getNickname(), member.getOriginImage(), member.getSaveImage(), member.getJoinDate(), member.getExitDate(), member.getIsAdmin(), member.getStatus());
//	}
	
	//Account
	public MemberDTO toDTO() {
		return new MemberDTO(id, password, refreshToken, name, nickname, originImage, saveImage, joinDate, exitDate, isAdmin, status);
	}
	
	//로그인
//	public LoginDTO toDTOWithMember() {
//		return new LoginDTO(id, name, nickname);
//	}
	
	//회원삭제
	public void deleteMember(DeleteMemberDTO deleteMemberDTO) {
		this.exitDate = deleteMemberDTO.getExitDate();
		this.status = 'X'; 
	}

	//회원정보수정
	public void updateMember(UpdateMemberDTO updateMemberDTO) {
		this.name = updateMemberDTO.getName();
		this.nickname = updateMemberDTO.getNickname();
		this.password = updateMemberDTO.getPassword();
		this.originImage = updateMemberDTO.getOriginImage();
		this.saveImage = updateMemberDTO.getSaveImage();
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", refreshToken=" + refreshToken + ", name=" + name
				+ ", nickname=" + nickname + ", originImage=" + originImage + ", saveImage=" + saveImage + ", joinDate="
				+ joinDate + ", exitDate=" + exitDate + ", isAdmin=" + isAdmin + ", status=" + status + "]";
	}

	



}