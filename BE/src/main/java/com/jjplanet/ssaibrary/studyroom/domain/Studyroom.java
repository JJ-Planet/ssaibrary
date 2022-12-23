package com.jjplanet.ssaibrary.studyroom.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED) // 동일한 패키지 내 클래스에서만 객체 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
}
