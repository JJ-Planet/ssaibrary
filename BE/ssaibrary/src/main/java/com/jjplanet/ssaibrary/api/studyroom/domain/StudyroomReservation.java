package com.jjplanet.ssaibrary.api.studyroom.domain;

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
import com.jjplanet.ssaibrary.api.studyroom.dto.StudyroomReservationDTO;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 동일한 패키지 내 클래스에서만 객체 생성
public class StudyroomReservation {

	// 번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Long id;

	// 예약자아이디, 예약자닉네임
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "member_id", referencedColumnName = "id"),
			@JoinColumn(name = "member_nickname", referencedColumnName = "nickname") })
	private Member member;

	// 스터디룸번호
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studyroom_id")
	private Studyroom studyroom;

	// 이용목적
	private String purpose;

	// 인원수
	private int userCount;

	// 예약시작일시
	private String startDate;

	// 예약시간
	private int time;

	// 입실시간
	private String checkinDate;

	// 퇴실시간
	private String checkoutDate;

	// 상태(W:대기,A:사용중,C:사용완료,X:취소)
	private char status;

	@Builder
	public StudyroomReservation(StudyroomReservationDTO studyroomReservationDTO, Member member, Studyroom studyroom) {
		this.member = member;
		this.studyroom = studyroom;
		this.purpose = studyroomReservationDTO.getPurpose();
		this.userCount = studyroomReservationDTO.getUserCount();
		this.startDate = studyroomReservationDTO.getStartDate();
		this.time = studyroomReservationDTO.getTime();
		this.checkinDate = studyroomReservationDTO.getCheckinDate();
		this.checkoutDate = studyroomReservationDTO.getCheckoutDate();
		this.status = studyroomReservationDTO.getStatus();
	}

	public StudyroomReservationDTO toDTO() {
		return new StudyroomReservationDTO(id, member.getId(), member.getNickname(), studyroom.getId(), purpose,
				userCount, startDate, time, checkinDate, checkoutDate, status);
	}

	public void updateStatus(char status) {
		this.status = status;
	}
}
