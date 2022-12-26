package com.jjplanet.ssaibrary.comment.domain;

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

import com.jjplanet.ssaibrary.community.domain.Community;
import com.jjplanet.ssaibrary.member.domain.Member;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED) //모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본생성자 생성
@Getter //getter 생성
public class Comment {
	
	//댓글번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//글번호
	@ManyToOne(cascade = CascadeType.REMOVE, targetEntity = Community.class)
	@JoinColumn(name = "community_id")
	//@Column(name = "community_id", nullable = false)
	private int communityId;
	
	//작성자닉네임
	@ManyToOne(targetEntity = Member.class, cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "member_nickname", referencedColumnName = "nickname")
	//@Column(name = "member_nickname", nullable = false, length = 20)
	private String memberNickname;
	
	//내용
	@Column(nullable = false, length = 2000)
	private String content;
	
	//부모댓글
	@Column(name = "parent_id", nullable = false, columnDefinition = "DEFAULT 0")
	private int parentId;
	
	//댓글계층(깊이)
	@Column(name = "depth_no", nullable = false, columnDefinition = "DEFAULT 0")
	private int depthNo;
	
	//정렬순서
	@Column(name = "order_no", nullable = false, columnDefinition = "DEFAULT 0")
	private int orderNo;
	
	//좋아요수
	@Column(name = "like_count", nullable = true, columnDefinition = "DEFAULT 0")
	private int likeCount;
	
	//등록일시
	@Column(name = "register_date", nullable = false, columnDefinition = "DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;
	
	//상태(V:노출,D:삭제,B:신고)
	@Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'V'")
	private char status;
	

}
