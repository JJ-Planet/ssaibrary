package com.jjplanet.ssaibrary.member.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.member.dto.DeleteMemberDTO;
import com.jjplanet.ssaibrary.member.dto.FindMemberDTO;
import com.jjplanet.ssaibrary.member.dto.JoinMemberDTO;
import com.jjplanet.ssaibrary.member.dto.MemberRequestDTO;
import com.jjplanet.ssaibrary.member.dto.UpdateMemberDTO;
import com.jjplanet.ssaibrary.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

	private final MemberRepository memberRepository;

	//회원가입
	@Override
	public void joinMember(JoinMemberDTO m) {
		Member member = new Member(m.getId(), m.getPassword(), m.getName(), m.getNickname(), m.getOriginImage(), m.getSaveImage(), m.getJoinDate(), m.getIsAdmin(), m.getStatus());

		memberRepository.save(member);
	}

	//Account
	@Override
	public FindMemberDTO findMember(String id) {

		Member m = memberRepository.findOneById(id).get();

		if(m==null) {
			System.out.println("유효한 회원이 아님" + id);
		}


		FindMemberDTO member = new FindMemberDTO(m.getId(), m.getPassword(), m.getName(), m.getNickname(), m.getOriginImage(), m.getSaveImage());

		return member;
	}

	//회원삭제
	public DeleteMemberDTO deleteMember(String id) {
		Member m = memberRepository.findOneById(id).get();

		if(m==null) {
			System.out.println("유효한 회원이 아닙니다.");
		}
		Date now = new Date();

		m.setExitDate(now);
		m.setStatus('X');

		memberRepository.save(m);

		DeleteMemberDTO member = new DeleteMemberDTO(m.getExitDate(), m.getStatus());

		return member;

	}


	//회원정보수정
	public UpdateMemberDTO updateMember(UpdateMemberDTO mydto) {
		Member m = memberRepository.findOneById(mydto.getId()).get();

		if(m==null) {
			System.out.println("유효한 회원이 아닙니다.");

		}

		m.setName(mydto.getName());
		m.setNickname(mydto.getNickname());
		m.setPassword(mydto.getPassword());

		memberRepository.save(m);

		UpdateMemberDTO member = new UpdateMemberDTO(m.getName(), m.getNickname(), m.getPassword());

		return member;

	}

}