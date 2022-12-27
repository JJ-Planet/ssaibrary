package com.jjplanet.ssaibrary.notice.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jjplanet.ssaibrary.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FindOneNoticeByIdDTO {
	
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
