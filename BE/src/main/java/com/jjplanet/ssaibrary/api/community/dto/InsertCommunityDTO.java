package com.jjplanet.ssaibrary.api.community.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * post, put 요청시
 * 
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsertCommunityDTO {


	// 작성자 닉네임
	private String memberNickname;

	// 제목
	private String title;

	// 내용
	private String content;

	// 등록일시
	private Date registerDate;

	// 상태(V:노출,D:삭제,B:신고)
	private char status;

}
