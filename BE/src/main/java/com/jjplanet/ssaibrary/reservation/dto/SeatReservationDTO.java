package com.jjplanet.ssaibrary.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SeatReservationDTO {

	// 번호
	private Long id;

	// 예약자아이디
	private String member_id;

	// 예약자닉네임
	private String member_nickname;

	// 좌석번호
	private Long seat_id;

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

	// 연장시간
	private int addTime;

	// 연장횟수
	private int addCount;

	// 상태(W:대기,A:사용중,C:사용완료,X:취소)
	private char status;
}
