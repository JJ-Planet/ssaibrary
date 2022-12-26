package com.jjplanet.ssaibrary.member.service;

import com.jjplanet.ssaibrary.member.dto.DeleteMemberDTO;
import com.jjplanet.ssaibrary.member.dto.FindMemberDTO;
import com.jjplanet.ssaibrary.member.dto.JoinMemberDTO;
import com.jjplanet.ssaibrary.member.dto.UpdateMemberDTO;

public interface MemberService {

	void joinMember(JoinMemberDTO m); //회원가입

	FindMemberDTO findMember(String id); //Account

	public DeleteMemberDTO deleteMember(String id); //회원삭제

	public UpdateMemberDTO updateMember(UpdateMemberDTO mydto); //회원정보수정


}