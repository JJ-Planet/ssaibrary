package com.jjplanet.ssaibrary.api.notice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * post, put요청
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateNoticeDTO {
	
	//글번호
	private Long id;
	
	//작성자아이디
	private String memberId;
	
	//제목
	private String title;
	
	//내용
	private String content;
	
	//수정일시
	private Date updateDate;
	
	//주요공지사항여부(Y:주요공지사항,N:일반공지사항)
	private char isPriority;


}
