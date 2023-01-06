package com.jjplanet.ssaibrary.studyroom.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.jjplanet.ssaibrary.studyroom.dto.StudyroomStateDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 동일한 패키지 내 클래스에서만 객체 생성
public class StudyroomState {

	// 번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Long id;

	// 스터디룸예약번호
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studyroom_reservation_id")
	private StudyroomReservation studyroomReservation;

	// 청결상태(Y/N)
	private char isDirty;

	// 손상상태(Y/N)
	private char isDamage;

	// 잠금상태(Y/N)
	private char isNotLock;

	// 원본이미지명
	private String originImage;

	// 저장이미지명
	private String saveImage;

	@Builder
	public StudyroomState(StudyroomStateDTO studyroomStateDTO, StudyroomReservation studyroomReservation) {
		this.studyroomReservation = studyroomReservation;
		this.isDirty = studyroomStateDTO.getIsDirty();
		this.isDamage = studyroomStateDTO.getIsDamage();
		this.isNotLock = studyroomStateDTO.getIsNotLock();
		this.originImage = studyroomStateDTO.getOriginImage();
		this.saveImage = studyroomStateDTO.getSaveImage();
	}

	public StudyroomStateDTO toDTO() {
		return new StudyroomStateDTO(id, studyroomReservation.getId(), isDirty, isDamage, isNotLock, originImage,
				saveImage);
	}
}
