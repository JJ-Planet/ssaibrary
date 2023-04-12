package com.jjplanet.ssaibrary.api.faq.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FaqDTO {

	// 글번호
	private Long id;

	// 질문
	private String question;

	// 답변
	private String answer;

	// 상태(V:노출,D:삭제)
	private char status;

}
