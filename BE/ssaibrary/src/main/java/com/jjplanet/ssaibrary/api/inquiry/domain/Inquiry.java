package com.jjplanet.ssaibrary.api.inquiry.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jjplanet.ssaibrary.api.inquiry.dto.AnswerInquiryDTO;
import com.jjplanet.ssaibrary.api.inquiry.dto.InquiryDTO;
import com.jjplanet.ssaibrary.api.inquiry.dto.InsertInquiryDTO;
import com.jjplanet.ssaibrary.api.member.domain.Member;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED) //모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본생성자 생성
@Getter //getter 생성
public class Inquiry {

	//글번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//작성자닉네임
	@ManyToOne(targetEntity = Member.class, cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "member_nickname", referencedColumnName = "nickname")
	private Member member;

	//제목
	@Column(nullable = false, length = 100)
	private String title;

	//질문
	@Column(nullable = false, length = 2000)
	private String question;

	//답변
	@Setter
	@Column(nullable = true, length = 2000)
	private String answer;

	//등록일시
	@Column(name = "register_date", nullable = false, columnDefinition = "DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;

	//상태(W:답변대기,C:답변완료,D:삭제)
	@Setter
	@Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'W'")
	private char status;
	

	//글 작성
	@Builder
	public Inquiry(Member member, InsertInquiryDTO insertInquiryDTO) {
		this.member = member;
		this.title = insertInquiryDTO.getTitle();
		this.question = insertInquiryDTO.getQuestion();
		this.registerDate = insertInquiryDTO.getRegisterDate();
		this.status = 'W';
	}

	// 전체목록조회
	public InquiryDTO toDTO() {
		return new InquiryDTO(id, member.getNickname(), title, question, answer, registerDate, status);
	}

	// 답변하기
	public void anserInquiry(AnswerInquiryDTO answerInquiryDTO) {
		this.answer = answerInquiryDTO.getAnswer();
		this.status = 'C';
	}
	
	// 삭제하기
	public void deleteInquiry(char status) {
		this.status = status;
	}
}