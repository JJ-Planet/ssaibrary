package com.jjplanet.ssaibrary.api.comment.dto;

import java.util.Date;

import com.jjplanet.ssaibrary.api.comment.domain.Comment;

import lombok.Data;

@Data
public class FindAllReCommentDTO {
	
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
		
	public FindAllReCommentDTO(Comment reComment) {
		this.id = reComment.getId();
		this.communityId = reComment.getCommunity().getId();
		this.memberNickname = reComment.getMember().getNickname();
		this.content = reComment.getContent();
		this.parentId = reComment.getParentComment().getId();
		this.likeCount = reComment.getLikeCount();
		this.registerDate = reComment.getRegisterDate();
		this.status = reComment.getStatus();
	}

}
