package com.jjplanet.ssaibrary.api.room.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.jjplanet.ssaibrary.api.room.dto.RoomDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 동일한 패키지 내 클래스에서만 객체 생성
@AllArgsConstructor
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

	@Builder
	public Room(RoomDTO roomDTO) {
		this.id = roomDTO.getId();
		this.floor = roomDTO.getFloor();
		this.totalSeat = roomDTO.getTotalSeat();
		this.reserveSeat = roomDTO.getReserveSeat();
		this.isAvailable = roomDTO.getIsAvailable();
	}

	public RoomDTO toDTO() {
		return new RoomDTO(id, floor, totalSeat, reserveSeat, isAvailable);
	}

	public void updateRoom(RoomDTO roomDTO) {
		this.floor = roomDTO.getFloor();
		this.totalSeat = roomDTO.getTotalSeat();
		this.reserveSeat = roomDTO.getReserveSeat();
		this.isAvailable = roomDTO.getIsAvailable();
	}
}
