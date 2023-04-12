package com.jjplanet.ssaibrary.api.comment.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsertCommentDTO {
	
	//글번호
	private Long communityId;
	
	//작성자닉네임
	private String memberNickname;
	
	//내용
	private String content;
	
	//등록일시
	private Date registerDate;

	//상태(V:노출,D:삭제,B:신고)
	private char status;
	

}
