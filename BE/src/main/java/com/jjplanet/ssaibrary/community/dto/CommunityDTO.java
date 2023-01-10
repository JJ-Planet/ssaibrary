package com.jjplanet.ssaibrary.community.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommunityDTO {

	// 글번호
	private Long id;

	// 작성자 닉네임
	private String memberNickname;

	// 제목
	private String title;

	// 내용
	private String content;

	// 조회수
	private int hitCount;

	// 좋아요수
	private int likeCount;

	// 등록일시
	private Date registerDate;

	// 수정일시
	private Date updateDate;

	// 상태(V:노출,D:삭제,B:신고)
	private char status;

}
