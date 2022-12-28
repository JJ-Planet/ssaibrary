package com.jjplanet.ssaibrary.studyroom.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudyroomStateDTO {

	// 번호
	private Long id;
	
	// 스터디룸예약번호
	private Long studyroomReservationID;

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
}
