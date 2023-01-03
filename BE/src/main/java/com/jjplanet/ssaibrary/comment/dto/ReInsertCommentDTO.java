package com.jjplanet.ssaibrary.comment.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jjplanet.ssaibrary.comment.domain.Comment;
import com.jjplanet.ssaibrary.community.domain.Community;
import com.jjplanet.ssaibrary.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReInsertCommentDTO {
	
	//글번호
	private Long communityId;

	//작성자닉네임
	private String memberNickname;

	//내용
	private String content;

	//부모댓글
	private Long parentId;

	//자식댓글
	private List<Comment> childList = new ArrayList<>();

	//등록일시
	private Date registerDate;

	//상태(V:노출,D:삭제,B:신고)
	private char status;

}
