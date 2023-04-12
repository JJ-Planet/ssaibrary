package com.jjplanet.ssaibrary.api.faq.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFaqDTO {

	// 글번호
	private Long id;

	// 질문
	private String question;

	// 답변
	private String answer;

}
