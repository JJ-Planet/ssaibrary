package com.jjplanet.ssaibrary.api.faq.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jjplanet.ssaibrary.api.faq.dto.FaqDTO;
import com.jjplanet.ssaibrary.api.faq.dto.InsertFaqDTO;
import com.jjplanet.ssaibrary.api.faq.dto.UpdateFaqDTO;

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
	public Faq(InsertFaqDTO insertFaqDTO) {
		this.question = insertFaqDTO.getQuestion();
		this.answer = insertFaqDTO.getAnswer();
		this.status = 'V';
	}
	
	public FaqDTO toDTO() {
		return new FaqDTO(id, question, answer, status);
	}
	
	// 글 수정
	public void updateFaq(UpdateFaqDTO updateFaqDTO) {
		this.question = updateFaqDTO.getQuestion();
		this.answer = updateFaqDTO.getAnswer();
	}
	
	// 글 삭제
	public void deleteFaq(char status) {
		this.status = status;
	}

}