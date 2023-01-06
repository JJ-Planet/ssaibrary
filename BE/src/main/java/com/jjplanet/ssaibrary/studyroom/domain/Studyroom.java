package com.jjplanet.ssaibrary.studyroom.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.jjplanet.ssaibrary.studyroom.dto.StudyroomDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
		this.id = studyroomDTO.getId();
		this.floor = studyroomDTO.getFloor();
		this.size = studyroomDTO.getSize();
		this.maxUser = studyroomDTO.getMaxUser();
		this.status = studyroomDTO.getStatus();
	}

	public StudyroomDTO toDTO() {
		return new StudyroomDTO(id, floor, size, maxUser, status);
	}

	public void updateRoom(StudyroomDTO studyroomDTO) {
		this.floor = studyroomDTO.getFloor();
		this.size = studyroomDTO.getSize();
		this.maxUser = studyroomDTO.getMaxUser();
		this.status = studyroomDTO.getStatus();
	}
}
