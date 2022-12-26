package com.jjplanet.ssaibrary.reservation.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyroomState {

	// 번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Long id;

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
