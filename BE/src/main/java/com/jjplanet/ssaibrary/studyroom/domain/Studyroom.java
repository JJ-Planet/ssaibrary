package com.jjplanet.ssaibrary.studyroom.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.jjplanet.ssaibrary.room.domain.Room;
import com.jjplanet.ssaibrary.room.dto.RoomDTO;
import com.jjplanet.ssaibrary.studyroom.dto.StudyroomDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 동일한 패키지 내 클래스에서만 객체 생성
@AllArgsConstructor
public class Studyroom {

	// 스터디룸번호
	@Id
	private Long id;

	// 층수
	private int floor;

	// 방크기
	private int size;

	// 최대인원수
	private int maxUser;

	// 상태(W:대기중,R:예약중,A:사용중,X:이용불가능)
	private char status;
	
	@Builder
	public Studyroom(StudyroomDTO studyroomDTO) {
		this.floor = studyroomDTO.getFloor();
		this.size = studyroomDTO.getSize();
		this.maxUser = studyroomDTO.getMaxUser();
		this.status = studyroomDTO.getStatus();
	}

//	public static StudyroomDTO toDTOWithStudyroom(Studyroom studyroom) {
//		return new StudyroomDTO(studyroom.getId(), studyroom.getFloor(), studyroom.getTotalSeat(), studyroom.getReserveSeat(),
//				studyroom.getIsAvailable());
//	}

//	public RoomDTO toDTO() {
//		return new RoomDTO(id, floor, totalSeat, reserveSeat, isAvailable);
//	}
//
//	public void updateRoom(RoomDTO roomDTO) {
//		this.floor = roomDTO.getFloor();
//		this.totalSeat = roomDTO.getTotalSeat();
//		this.reserveSeat = roomDTO.getReserveSeat();
//		this.isAvailable = roomDTO.getIsAvailable();
//	}
}
