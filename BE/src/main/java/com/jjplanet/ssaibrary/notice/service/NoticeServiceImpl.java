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
		
		if (!member.getId().equals("admin")) {
			throw new NotFoundException("작성 권한이 없는 계정입니다.");
		}
		Notice notice = Notice.builder().insertNoticeDTO(insertNoticeDTO).member(member).build();

		noticeRepository.save(notice);
	}

	// 전체목록조회
	@Override
	public Map<String, Object> findAllNotice() throws NotFoundException {
//		return noticeRepository.findAll().stream().map(Notice::toDTO).collect(Collectors.toList());

		List<Notice> list = noticeCustomRepository.findAllList();
		List<FindAllNoticeDTO> noticeList = new ArrayList<>();

		Map<String, Object> result = new HashMap<String, Object>();

		for (Notice n : list) {
			FindAllNoticeDTO output = new FindAllNoticeDTO(n.getId(), n.getMemberId().getId(), n.getTitle(),
					n.getContent(), n.getHitCount(), n.getRegisterDate(), n.getUpdateDate(), n.getIsPriority(),
					n.getStatus());
			noticeList.add(output);
		}
		result.put("noticeList", noticeList);

		return result;
	}

	// 상세조회
	@Override
	public NoticeDTO findOneNoticeById(Long id) throws NotFoundException {

		Optional<Notice> n = noticeRepository.findById(id);
		if (!n.isPresent()) {
			throw new NotFoundException("존재 하지 않는 게시글입니다.");
		}

		NoticeDTO notice = new NoticeDTO(n.get().getId(), n.get().getMemberId().getId(),
				n.get().getTitle(), n.get().getContent(), n.get().getHitCount(), n.get().getRegisterDate(),
				n.get().getUpdateDate(), n.get().getIsPriority(), n.get().getStatus());

		return notice;
	}

	// 글수정
	@Override
	public void updateNotice(UpdateNoticeDTO n) throws NotFoundException {

		Optional<Member> writer = memberRepository.findById(n.getMemberId());
		
		if(!writer.isPresent()) {
			throw new NotFoundException("존재하지 않는 사용자입니다.");
		}

		if (!writer.get().getId().equals("admin")) {
			throw new NotFoundException("수정 권한이 없는 계정입니다.");
		}

		Optional<Notice> notice = noticeRepository.findById(n.getId());

		notice.get().setTitle(n.getTitle());
		notice.get().setContent(n.getContent());
		notice.get().setUpdateDate(n.getUpdateDate());
		notice.get().setIsPriority(n.getIsPriority());

		noticeRepository.save(notice.get());
	}

	// 글삭제
	@Override
	public void deleteNotice(Long id) throws NotFoundException {

		Optional<Notice> notice = noticeRepository.findById(id);

		notice.get().setStatus('D');

		noticeRepository.save(notice.get());

	}

}