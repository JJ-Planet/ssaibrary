package com.jjplanet.ssaibrary.api.member.dto;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class DeleteMemberDTO {
	
	//아이디(전화번호)
	private String id;
	
	//탈퇴일시
	private Date exitDate; 
		
	
}
