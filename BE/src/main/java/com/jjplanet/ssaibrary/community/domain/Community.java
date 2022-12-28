package com.jjplanet.ssaibrary.community.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jjplanet.ssaibrary.member.domain.Member;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * pk가 아닌 컬럼을 참조할 때 referencedColumnName을 꼭!! 적어줘야함.
 * 왜냐하면, referencedColumnName 기본값이 pk라서  
 * 생략시 pk를 참조하는 것으로 인식함.
 *  (memberNickname 변수의 @JoinColumn 참고)
 *  
 *  String 타입은 무조건 @Column 에다가 length를 꼭 적어줘야 함.
 */

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED) // 모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본생성자 생성
@Getter // getter 생성
public class Community {

	// 글번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_Increment를 지원해줌.
	private Long id;

	// 작성자 닉네임
	@ManyToOne(targetEntity = Member.class, cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "member_nickname", referencedColumnName = "nickname")
	private Member memberNickname;

	// 제목
	@Setter
	@Column(nullable = false, length = 100)
	private String title;

	// 내용
	@Setter
	@Column(nullable = false, length = 2000)
	private String content;

	// 조회수
	@Column(name = "hit_count", nullable = true, columnDefinition = "DEFAULT 0")
	private int hitCount;

	// 좋아요수
	@Column(name = "like_count", nullable = true, columnDefinition = "DEFAULT 0")
	private int likeCount;

	// 등록일시
//	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	@Column(name = "register_date", nullable = false, columnDefinition = "DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;

	// 수정일시
	@Setter
	@Column(name = "update_date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	// 상태(V:노출,D:삭제,B:신고)
	@Setter
	@Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'V'")
	private char status;

	// 글작성
	@Builder
	public Community(Member memberNickname, String title, String content, Date registerDate, char status) {
		this.memberNickname = memberNickname;
		this.title = title;
		this.content = content;
		this.registerDate = registerDate;
		this.status = status;
	}

}