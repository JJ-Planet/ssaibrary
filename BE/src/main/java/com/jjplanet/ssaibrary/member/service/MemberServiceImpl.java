package com.jjplanet.ssaibrary.member.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.member.dto.FindMemberDTO;
import com.jjplanet.ssaibrary.member.dto.JoinMemberDTO;
import com.jjplanet.ssaibrary.member.dto.UpdateMemberDTO;
import com.jjplanet.ssaibrary.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.notice.repository.NoticeCustomRepositoryImpl;
import com.jjplanet.ssaibrary.notice.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	// 회원가입
	@Override
	public void joinMember(JoinMemberDTO m) throws NotFoundException {
		Member member = new Member(m.getId(), m.getPassword(), m.getName(), m.getNickname(), m.getOriginImage(),
				m.getSaveImage(), m.getJoinDate(), m.getIsAdmin(), m.getStatus());

		// 아이디 중복 체크
		duplicateId(member.getId());

		// 닉네임 중복 체크
		duplicateNickname(member.getNickname());

		memberRepository.save(member);

	}

	// 아이디 중복 체크
	private void duplicateId(String id) {
		if (memberRepository.findOneById(id) != null) {
			throw new NotFoundException("중복된 아이디입니다.");
		}
	}

	// 닉네임 중복체크
	private void duplicateNickname(String nickname) {
		if (memberRepository.findByNickname(nickname) != null) {
			throw new NotFoundException("중복된 닉네임입니다.");
		}

	}

	// Account
	@Override
	public FindMemberDTO findMember(String id) {

		Member m = memberRepository.findOneById(id).orElseThrow(NotFoundException::new);

		FindMemberDTO member = new FindMemberDTO(m.getId(), m.getPassword(), m.getName(), m.getNickname(),
				m.getOriginImage(), m.getSaveImage());

		return member;
	}

	// 회원삭제
	public void deleteMember(String id) throws NotFoundException {
		Member member = memberRepository.findOneById(id).orElseThrow(NotFoundException::new);

		if (member.getStatus() == 'X') {
			throw new NotFoundException("유효한 회원이 아닙니다.");
		}
		Date now = new Date();

		member.setExitDate(now);
		member.setStatus('X');

		memberRepository.save(member);

	}

	// 회원정보수정
	public void updateMember(UpdateMemberDTO m) throws NotFoundException {
		Member member = memberRepository.findOneById(m.getId()).orElseThrow(NotFoundException::new);

		// 닉네임 중복 체크
		duplicateNickname(m.getNickname());

		member.setName(m.getName());
		member.setNickname(m.getNickname());
		member.setPassword(m.getPassword());

		memberRepository.save(member);

	}

}