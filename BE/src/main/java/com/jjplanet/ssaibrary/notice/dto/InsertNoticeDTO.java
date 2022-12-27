package com.jjplanet.ssaibrary.notice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsertNoticeDTO {
	
	//작성자아이디
	private String memberId;

	//제목
	private String title;

	//내용
	private String content;
	
	//등록일시
	private Date registerDate;

	//주요공지사항여부(Y:주요공지사항,N:일반공지사항)
	private char isPriority;

	//상태(V:노출,D:삭제)
	private char status;

}
