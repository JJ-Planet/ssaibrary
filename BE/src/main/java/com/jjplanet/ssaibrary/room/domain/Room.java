package com.jjplanet.ssaibrary.room.domain;

import com.jjplanet.ssaibrary.room.dto.RoomDTO;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 동일한 패키지 내 클래스에서만 객체 생성
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
		this.floor = roomDTO.getFloor();
		this.totalSeat = roomDTO.getTotalSeat();
		this.reserveSeat = roomDTO.getReserveSeat();
		this.isAvailable = roomDTO.getIsAvailable();
	}

	public static RoomDTO toDtoWithRoom(Room room) {
		return new RoomDTO(room.getId(), room.getFloor(), room.getTotalSeat(), room.getReserveSeat(), room.getIsAvailable());
	}

	public RoomDTO toDto() {
		return new RoomDTO(id, floor, totalSeat, reserveSeat, isAvailable);
	}

	public void updateRoom(RoomDTO roomDTO) {
		this.floor = roomDTO.getFloor();
		this.totalSeat = roomDTO.getTotalSeat();
		this.reserveSeat = roomDTO.getReserveSeat();
		this.isAvailable = roomDTO.getIsAvailable();
	}
}