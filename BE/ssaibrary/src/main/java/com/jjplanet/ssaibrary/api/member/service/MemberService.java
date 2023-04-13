package com.jjplanet.ssaibrary.api.member.service;

import java.util.List;

import com.jjplanet.ssaibrary.api.member.domain.Member;
import com.jjplanet.ssaibrary.api.member.dto.JoinMemberDTO;
import com.jjplanet.ssaibrary.common.exception.NotFoundException;
import com.jjplanet.ssaibrary.api.member.dto.DeleteMemberDTO;
import com.jjplanet.ssaibrary.api.member.dto.MemberDTO;
import com.jjplanet.ssaibrary.api.member.dto.UpdateMemberDTO;

public interface MemberService {

	// 회원가입
	void joinMember(JoinMemberDTO joinMemberDTO) throws NotFoundException;
	
	//로그인
	Member loginMember(String id, String password) throws NotFoundException;
	
	//Account List
	List<MemberDTO> findAllMember() throws NotFoundException;

	// Account
	MemberDTO findMember(String id) throws NotFoundException;

	// 회원삭제
	public void deleteMember(DeleteMemberDTO deleteMemberDTO) throws NotFoundException;

	// 회원정보수정
	public void updateMember(UpdateMemberDTO updateMemberDTO) throws NotFoundException;

}