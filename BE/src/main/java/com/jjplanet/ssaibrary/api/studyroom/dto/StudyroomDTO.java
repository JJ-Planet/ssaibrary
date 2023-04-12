package com.jjplanet.ssaibrary.api.studyroom.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudyroomDTO {
	
	// 스터디룸번호
	private Long id;

	// 층수
	private int floor;

	// 방크기
	private int size;

	// 최대인원수
	private int maxUser;

	// 상태(W:대기중,R:예약중,A:사용중,X:이용불가능)
	private char status;
}
