package com.jjplanet.ssaibrary.comment.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jjplanet.ssaibrary.comment.domain.Comment;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FindAllCommentDTO {
	
	//댓글번호
	private Long id;
	
	//글번호
	private Long communityId;

	//작성자닉네임
	private String memberNickname;

	//내용
	private String content;

	//부모댓글
	private Long parentId;

	
	//좋아요수
	private int likeCount;

	//등록일시
	private Date registerDate;

	//상태(V:노출,D:삭제,B:신고)
	private char status;
	
	//자식댓글
	private List<FindAllReCommentDTO> reCommentList;
	
	
	public FindAllCommentDTO(Comment comment, List<Comment> reCommentList) {
		this.id = comment.getId();
		this.communityId = comment.getCommunity().getId();
		this.memberNickname = comment.getMember().getNickname();
		this.content = comment.getContent();
		this.likeCount = comment.getLikeCount();
		this.registerDate = comment.getRegisterDate();
		this.status = comment.getStatus();
//		this.reCommentList = reCommentList.stream().map(FindAllReCommentDTO::new).toList();
	}

}
