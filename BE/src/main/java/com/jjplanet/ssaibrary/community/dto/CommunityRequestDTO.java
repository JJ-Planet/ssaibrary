package com.jjplanet.ssaibrary.community.dto;

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
public class CommunityRequestDTO {
	
	
	private Long id;
	private String memberNickname;
	private String title;
	private String content;
	private int hitCount;
	private int likeCount;
	private Date registerDate;
	private Date updateDate;
	private char status;
	
	//글작성
	@Builder
	public CommunityRequestDTO(String memberNickname, String title, String content, Date registerDate, char status) {
		this.memberNickname = memberNickname;
		this.title = title;
		this.content = content;
		this.registerDate = registerDate;
		this.status = status;
	}
	
	
	//글수정
	@Builder
	public CommunityRequestDTO(String title, String content, Date updateDate) {
		this.title = title;
		this.content = content;
		this.updateDate = updateDate;
	}

}
