package com.jjplanet.ssaibrary.member.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.member.dto.MemberRequestDTO;
import com.jjplanet.ssaibrary.member.dto.MemberResponseDTO;
import com.jjplanet.ssaibrary.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	
	private final MemberRepository memberRepository;

	//ȸ������
	@Override
	public void join(MemberRequestDTO m) {
		Member member = new Member(m.getId(), m.getPassword(), m.getName(), m.getNickname(), m.getOriginImage(), m.getSaveImage(), m.getJoinDate(), m.getIsAdmin(), m.getStatus());

		memberRepository.save(member);
	}

	//Account
	@Override
	public MemberResponseDTO getInfo(String id) {
		
		Member m = memberRepository.findById(id).get();
		
		if(m==null) {
			System.out.println("��ȿ�� ȸ���� �ƴ�" + id);
		}
		

		MemberResponseDTO member = new MemberResponseDTO(m.getId(), m.getPassword(), m.getName(), m.getNickname(), m.getOriginImage(), m.getSaveImage());
		
		return member;
	}
	
	
	//ȸ������ - ������
//	public void deleteById(String id) {
//		memberRepository.deleteById(id);
//	}
	
	//��¥ȸ������
	public MemberRequestDTO deleteMember(String id) {
		Member m = memberRepository.findById(id).get();
		
		if(m==null) {
			System.out.println("��ȿ�� ȸ���� �ƴմϴ�.");
		}
		Date now = new Date();
		
		m.setExitDate(now);
		m.setStatus('X');
		
		memberRepository.save(m);
		
		MemberRequestDTO member = new MemberRequestDTO(m.getExitDate(), m.getStatus());
		
		return member;
		
	}
	

	//ȸ����������
	public MemberRequestDTO updateMember(MemberRequestDTO mydto) {
		Member m = memberRepository.findById(mydto.getId()).get();
		
		if(m==null) {
			System.out.println("��ȿ�� ȸ���� �ƴմϴ�.");
			
		}
		
		m.setName(mydto.getName());
		m.setNickname(mydto.getNickname());
		m.setPassword(mydto.getPassword());
		
		memberRepository.save(m);
		
		MemberRequestDTO member = new MemberRequestDTO(m.getName(), m.getNickname(), m.getPassword());
		
		return member;
		
	}

}
