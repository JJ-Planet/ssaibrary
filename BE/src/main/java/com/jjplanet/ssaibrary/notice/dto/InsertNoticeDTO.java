package com.jjplanet.ssaibrary.notice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsertNoticeDTO {
	
	private String memberId;
	private String title;
	private String content;
	private Date registerDate;
	private char isPriority;
	private char status;

}
