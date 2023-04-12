package com.jjplanet.ssaibrary.api.seat.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.jjplanet.ssaibrary.api.member.domain.Member;
import com.jjplanet.ssaibrary.api.seat.dto.SeatReservationDTO;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 동일한 패키지 내 클래스에서만 객체 생성
@AllArgsConstructor
public class SeatReservation {

	// 번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Long id;

	// 예약자아이디, 예약자닉네임
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "member_id", referencedColumnName = "id"),
			@JoinColumn(name = "member_nickname", referencedColumnName = "nickname") })
	private Member member;

	// 좌석번호
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seat_id")
	private Seat seat;

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

	@Builder
	public SeatReservation(SeatReservationDTO seatReservaionDTO, Member member, Seat seat) {
		this.member = member;
		this.seat = seat;
		this.startDate = seatReservaionDTO.getStartDate();
		this.time = seatReservaionDTO.getTime();
		this.checkinDate = seatReservaionDTO.getCheckinDate();
		this.checkoutDate = seatReservaionDTO.getCheckoutDate();
		this.addTime = seatReservaionDTO.getAddTime();
		this.addCount = seatReservaionDTO.getAddCount();
		this.status = seatReservaionDTO.getStatus();
	}

	public SeatReservationDTO toDTO() {
		return new SeatReservationDTO(id, member.getId(), member.getNickname(), seat.getId(), startDate, time,
				checkinDate, checkoutDate, addTime, addCount, status);
	}

	public void updateAddData(int addTime) {
		this.addTime = this.addTime + addTime;
		addCount = addCount + 1;
	}

	public void updateStatus(char status) {
		this.status = status;
	}
}
