package com.jjplanet.ssaibrary.api.community.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCommunityDTO {

	// 글번호
	private Long id;

	// 작성자 닉네임
	private String memberNickname;

	// 제목
	private String title;

	// 내용
	private String content;

	// 수정일시
	private Date updateDate;

}
