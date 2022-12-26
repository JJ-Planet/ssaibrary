package com.jjplanet.ssaibrary.room.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED) // 동일한 패키지 내 클래스에서만 객체 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room {
	
	// 강의실번호
	@Id
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
