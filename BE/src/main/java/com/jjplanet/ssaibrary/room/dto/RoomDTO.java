package com.jjplanet.ssaibrary.room.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoomDTO {
	
	// 좌석번호
	private Long id;

	// 층수
	private int floor;

	// 총좌석수
	private int totalSeat;

	// 예약좌석수
	private int reserveSeat;

	// 사용가능여부(Y:가능,N:불가능)
	private char isAvailable;
}
