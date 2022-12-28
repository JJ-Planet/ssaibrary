package com.jjplanet.ssaibrary.seat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SeatReservationExtensionDTO {

	// 예약번호
	private Long id;

	// 연장시간
	private int addTime;
}
