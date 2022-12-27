package com.jjplanet.ssaibrary.member.service;

import javax.servlet.http.HttpSession;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.member.dto.FindMemberDTO;
import com.jjplanet.ssaibrary.member.dto.JoinMemberDTO;
import com.jjplanet.ssaibrary.member.dto.UpdateMemberDTO;

public interface MemberService {

	// 회원가입
	void joinMember(JoinMemberDTO m) throws NotFoundException;

	// Account
	FindMemberDTO findMember(String id) throws NotFoundException;

	// 회원삭제
	public void deleteMember(String id) throws NotFoundException;

	// 회원정보수정
	public void updateMember(UpdateMemberDTO m) throws NotFoundException;

}