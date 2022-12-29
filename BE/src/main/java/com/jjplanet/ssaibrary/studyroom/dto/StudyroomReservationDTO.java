package com.jjplanet.ssaibrary.studyroom.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudyroomReservationDTO {

	// 번호
	private Long id;

	// 예약자아이디
	private String memberId;

	// 예약자닉네임
	private String memberNickname;

	// 스터디룸번호
	private Long studyroomId;

	// 이용목적
	private String purpose;

	// 인원수
	private int userCount;

	// 예약일시
	private String reservationDate;

	// 예약시작일시
	private String startDate;

	// 예약시간
	private int time;

	// 입실시간
	private String checkinDate;

	// 퇴실시간
	private String checkoutDate;

	// 상태(W:대기,A:사용중,C:사용완료,X:취소)
	private char status;
}
