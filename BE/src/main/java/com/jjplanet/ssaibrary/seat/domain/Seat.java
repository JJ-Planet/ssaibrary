package com.jjplanet.ssaibrary.seat.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.jjplanet.ssaibrary.room.domain.Room;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seat {
	
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
}
