package com.jjplanet.ssaibrary.member.service;

import com.jjplanet.ssaibrary.member.dto.MemberRequestDTO;
import com.jjplanet.ssaibrary.member.dto.MemberResponseDTO;

public interface MemberService {
	
	void join(MemberRequestDTO m); //회원가입
	
	MemberResponseDTO getInfo(String id); //Account
	
	//public void deleteById(String id); //회원삭제 - 연습용
	public MemberRequestDTO deleteMember(String id); //진짜 회원삭제
	
	public MemberRequestDTO updateMember(MemberRequestDTO mydto); //회원정보수정


}
