package com.jjplanet.ssaibrary.member.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.member.dto.DeleteMemberDTO;
import com.jjplanet.ssaibrary.member.dto.FindMemberDTO;
import com.jjplanet.ssaibrary.member.dto.JoinMemberDTO;
import com.jjplanet.ssaibrary.member.dto.LoginDTO;
import com.jjplanet.ssaibrary.member.dto.MemberDTO;
import com.jjplanet.ssaibrary.member.dto.UpdateMemberDTO;
import com.jjplanet.ssaibrary.member.repository.MemberCustomRepositoryImpl;
import com.jjplanet.ssaibrary.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.notice.repository.NoticeCustomRepositoryImpl;
import com.jjplanet.ssaibrary.notice.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
	
	private final MemberCustomRepositoryImpl memberCustomRepository;

	// 회원가입
	@Override
	@Transactional
	public void joinMember(JoinMemberDTO joinMemberDTO) throws NotFoundException {
		
		Member member = Member.builder().joinMemberDTO(joinMemberDTO).build();

		// 아이디 중복 체크
		duplicateId(member.getId());

		// 닉네임 중복 체크
		duplicateNickname(member.getNickname());

		memberRepository.save(member);

	}

	// 아이디 중복 체크
	private void duplicateId(String id) {
		if (memberRepository.findById(id).isPresent()) {
			throw new NotFoundException("중복된 아이디입니다.");
		}
	}

	// 닉네임 중복체크
	private void duplicateNickname(String nickname) {
		if (memberRepository.findByNickname(nickname).isPresent()) {
			throw new NotFoundException("중복된 닉네임입니다.");
		}

	}
	
	//로그인
	@Override
	public Member loginMember(String id, String password) throws NotFoundException {

		
		Member loginUser = memberRepository.loginMember(id, password).orElseThrow(NotFoundException::new);
		
		if(loginUser.getStatus() == 'X') {
			throw new NotFoundException("탈퇴한 회원입니다.");
		}
		
		return loginUser;
	}
	
	//Account List
	@Override
	public List<MemberDTO> findAllMember() throws NotFoundException {
		return memberRepository.findAll().stream().map(Member::toDTO).collect(Collectors.toList());
	}

	// Account
	@Override
	public MemberDTO findMember(String id) throws NotFoundException  {
		return memberRepository.findById(id).orElseThrow(NotFoundException::new).toDTO();
	}
	
	

	// 회원삭제
	@Transactional
	public void deleteMember(DeleteMemberDTO deleteMemberDTO) throws NotFoundException {
		Member member = memberRepository.findById(deleteMemberDTO.getId()).orElseThrow(NotFoundException::new);

		if (member.getStatus() == 'X') {
			throw new NotFoundException("유효한 회원이 아닙니다.");
		}
		member.deleteMember(deleteMemberDTO);

	}

	// 회원정보수정
	@Transactional
	public void updateMember(UpdateMemberDTO updateMemberDTO) throws NotFoundException {
		Member member = memberRepository.findById(updateMemberDTO.getId()).orElseThrow(NotFoundException::new);

		// 닉네임 중복 체크
		duplicateNickname(updateMemberDTO.getNickname());

		member.updateMember(updateMemberDTO);
	}


}