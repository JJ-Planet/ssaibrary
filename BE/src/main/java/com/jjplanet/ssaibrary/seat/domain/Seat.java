package com.jjplanet.ssaibrary.seat.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.jjplanet.ssaibrary.room.domain.Room;
import com.jjplanet.ssaibrary.room.service.RoomService;
import com.jjplanet.ssaibrary.seat.domain.Seat;
import com.jjplanet.ssaibrary.seat.dto.SeatDTO;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 동일한 패키지 내 클래스에서만 객체 생성
@AllArgsConstructor
public class Seat {

	@Autowired
	private RoomService roomService;
	
	// 좌석번호
	@Id
	private Long id;

	// 강의실번호
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private Room room;

	// 비밀번호
	private String password;

	// 상태(W:대기중,R:예약중,A:사용중,X:이용불가능)
	private char status;
	
	@Builder
	public Seat(SeatDTO seatDTO, Room room) {
		this.room = room;
		this.password = seatDTO.getPassword();
		this.status = seatDTO.getStatus();
	}

	public static SeatDTO toDTOWithSeat(Seat seat) {
		return new SeatDTO(seat.getId(), seat.getRoom().getId(), seat.getPassword(), seat.getStatus());
	}

	public SeatDTO toDTO() {
		return new SeatDTO(id, room.getId(), password, status);
	}

	public void updateSeat(SeatDTO seatDTO, Room room) {
		this.room = room;
		this.password = seatDTO.getPassword();
		this.status = seatDTO.getStatus();
	}
}
