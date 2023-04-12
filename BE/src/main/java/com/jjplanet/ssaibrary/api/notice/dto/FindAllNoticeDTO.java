package com.jjplanet.ssaibrary.api.notice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * get요청
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FindAllNoticeDTO {
	
	//글번호
	private Long id;
	
	//작성자아이디
	private String memberId;

	//제목
	private String title;

	//내용
	private String content;
	
	//조회수
	private int hitCount;

	//등록일시
	private Date registerDate;

	//수정일시
	private Date updateDate;

	//주요공지사항여부(Y:주요공지사항,N:일반공지사항)
	private char isPriority;

	//상태(V:노출,D:삭제)
	private char status;	

}
