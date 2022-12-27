package com.jjplanet.ssaibrary.notice.dto;

import java.util.Date;

import com.jjplanet.ssaibrary.notice.domain.Notice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * get요청
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FindAllNoticeDTO {
	
	private Long id;
	private String memberId;
	private String title;
	private String content;
	private int hitCount;
	private Date registerDate;
	private Date updateDate;
	private char isPriority;
	private char status;
	

}