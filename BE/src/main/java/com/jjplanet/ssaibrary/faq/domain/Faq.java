package com.jjplanet.ssaibrary.faq.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jjplanet.ssaibrary.inquiry.domain.Inquiry;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED) // 모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본생성자 생성
@Getter // getter 생성
public class Faq {

	// 글번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 질문
	@Setter
	@Column(nullable = false, length = 2000)
	private String question;

	// 답변
	@Setter
	@Column(nullable = false, length = 2000)
	private String answer;

	// 상태(V:노출,D:삭제)
	@Setter
	@Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'V'")
	private char status;

	// 글 작성
	@Builder
	public Faq(String question, String answer, char status) {
		this.question = question;
		this.answer = answer;
		this.status = status;
	}

}