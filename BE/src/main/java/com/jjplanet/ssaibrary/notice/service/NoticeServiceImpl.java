package com.jjplanet.ssaibrary.notice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.notice.domain.Notice;
import com.jjplanet.ssaibrary.notice.dto.FindAllNoticeDTO;
import com.jjplanet.ssaibrary.notice.dto.InsertNoticeDTO;
import com.jjplanet.ssaibrary.notice.dto.NoticeDTO;
import com.jjplanet.ssaibrary.notice.dto.UpdateNoticeDTO;
import com.jjplanet.ssaibrary.notice.repository.NoticeCustomRepositoryImpl;
import com.jjplanet.ssaibrary.notice.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

	private final NoticeRepository noticeRepository;
	private final NoticeCustomRepositoryImpl noticeCustomRepository;
	private final MemberRepository memberRepository;

	// 글작성
	@Override
	public void insertNotice(InsertNoticeDTO insertNoticeDTO) throws NotFoundException {
		Member member = memberRepository.findById(insertNoticeDTO.getMemberId()).orElseThrow(NotFoundException::new);
		
		if (member.getIsAdmin()=='N') {
			throw new NotFoundException("작성 권한이 없는 계정입니다.");
		}
		Notice notice = Notice.builder().insertNoticeDTO(insertNoticeDTO).member(member).build();

		noticeRepository.save(notice);
	}

	// 전체목록조회
	@Override
	public List<NoticeDTO> findAllNotice() throws NotFoundException {
		
		//상태가 V인 것들만 목록으로 보여주기 위해 findAll()을 안 쓰고 findByStatus를 적어줌.
		return noticeRepository.findByStatus('V').stream().map(Notice::toDTO).collect(Collectors.toList());

	}

	// 상세조회
	@Override
	public NoticeDTO findOneNoticeById(Long id) throws NotFoundException {
		
		return noticeRepository.findById(id).orElseThrow(NotFoundException::new).toDTO();

	}

	// 글수정
	@Override
	public void updateNotice(UpdateNoticeDTO updateNoticeDTO) throws NotFoundException {
		
		Member member = memberRepository.findById(updateNoticeDTO.getMemberId()).orElseThrow(NotFoundException::new);
		
		if(member.getIsAdmin()=='N') {
			throw new NotFoundException("수정 권한이 없는 사용자입니다.");
		}
		
		Notice notice = noticeRepository.findById(updateNoticeDTO.getId()).orElseThrow(NotFoundException::new);
		
		notice.updateNotice(updateNoticeDTO);

		
	}

	// 글삭제
	@Override
	public void deleteNotice(Long id) throws NotFoundException {
		
		Notice notice = noticeRepository.findById(id).orElseThrow(NotFoundException::new);
		
		Member member = memberRepository.findById(notice.getMember().getId()).orElseThrow(NotFoundException::new);
		
		if(member.getIsAdmin()=='N') {
			throw new NotFoundException("삭제 권한이 없는 사용자입니다.");
		}
		
		
		notice.deleteNotice('D');


	}

}