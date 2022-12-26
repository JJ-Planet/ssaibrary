package com.jjplanet.ssaibrary.community.dto;

import java.util.Date;

import com.jjplanet.ssaibrary.community.domain.Community;

import lombok.Getter;

/*
 * get 요청시
 */
@Getter
public class CommunityResponseDTO {
	
	private Long id;
	private String memberNickname;
	private String title;
	private String content;
	private int hitCount;
	private int likeCount;
	private Date registerDate;
	private Date updateDate;
	private char status;
	


}
