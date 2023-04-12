package com.jjplanet.ssaibrary.api.inquiry.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsertInquiryDTO {
	
	//작성자닉네임
	private String memberNickname;

	//제목
	private String title;

	//질문
	private String question;

	//등록일시
	private Date registerDate;
	
	//상태(W:답변대기,C:답변완료,D:삭제)
	private char status;

}
