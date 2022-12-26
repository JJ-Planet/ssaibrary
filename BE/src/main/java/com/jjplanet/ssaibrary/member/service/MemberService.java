package com.jjplanet.ssaibrary.member.service;

import com.jjplanet.ssaibrary.member.dto.MemberRequestDTO;
import com.jjplanet.ssaibrary.member.dto.MemberResponseDTO;

public interface MemberService {
	
	void join(MemberRequestDTO m); //ȸ������
	
	MemberResponseDTO getInfo(String id); //Account
	
	//public void deleteById(String id); //ȸ������ - ������
	public MemberRequestDTO deleteMember(String id); //��¥ ȸ������
	
	public MemberRequestDTO updateMember(MemberRequestDTO mydto); //ȸ����������


}
