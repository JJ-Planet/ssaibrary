package com.jjplanet.ssaibrary.faq.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsertFaqDTO {

	// 질문
	private String question;

	// 답변
	private String answer;

	// 상태(V:노출,D:삭제)
	private char status;

}
