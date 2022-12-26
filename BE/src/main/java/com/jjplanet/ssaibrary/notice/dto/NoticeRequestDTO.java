package com.jjplanet.ssaibrary.notice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * post, put요청
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeRequestDTO {
	
	private Long id;
	private String memberId;
	private String title;
	private String content;
	private int hitCount;
	private Date registerDate;
	private Date updateDate;
	private char isPriority;
	private char status;

	@Override
	public String toString() {
		return "NoticeRequestDTO [memberId=" + memberId + ", title=" + title + ", content=" + content + ", hitCount="
				+ hitCount + ", registerDate=" + registerDate + ", isPriority=" + isPriority + ", status=" + status
				+ "]";
	}





}
