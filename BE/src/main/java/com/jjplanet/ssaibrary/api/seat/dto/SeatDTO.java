package com.jjplanet.ssaibrary.api.seat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SeatDTO {

	// 좌석번호
	private Long id;

	// 강의실번호
	private Long roomId;

	// 비밀번호
	private String password;

	// 상태(W:대기중,R:예약중,A:사용중,X:이용불가능)
	private char status;
}
