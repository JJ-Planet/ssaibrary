package com.jjplanet.ssaibrary.notice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.notice.domain.Notice;
import com.jjplanet.ssaibrary.notice.dto.FindAllNoticeDTO;
import com.jjplanet.ssaibrary.notice.dto.FindOneNoticeByIdDTO;
import com.jjplanet.ssaibrary.notice.dto.InsertNoticeDTO;
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
	public void insertNotice(InsertNoticeDTO n) throws NotFoundException {
		Optional<Member> writer = memberRepository.findOneById(n.getMemberId());
		
		if(!writer.isPresent()) {
			throw new NotFoundException("존재하지 않는 사용자입니다.");
		}
		
		if (!writer.get().getId().equals("admin")) {
			throw new NotFoundException("작성 권한이 없는 계정입니다.");
		}

		n.setStatus('V');

		Notice notice = new Notice(writer.get(), n.getTitle(), n.getContent(), n.getRegisterDate(), n.getIsPriority(),
				n.getStatus());

		noticeRepository.save(notice);
	}

	// 전체목록조회
	@Override
	public Map<String, Object> findAllNotice() throws NotFoundException {

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
	public FindOneNoticeByIdDTO findOneNoticeById(Long id) throws NotFoundException {

		Optional<Notice> n = noticeRepository.findOneById(id);
		if (!n.isPresent()) {
			throw new NotFoundException("존재 하지 않는 게시글입니다.");
		}

		FindOneNoticeByIdDTO notice = new FindOneNoticeByIdDTO(n.get().getId(), n.get().getMemberId().getId(),
				n.get().getTitle(), n.get().getContent(), n.get().getHitCount(), n.get().getRegisterDate(),
				n.get().getUpdateDate(), n.get().getIsPriority(), n.get().getStatus());

		return notice;
	}

	// 글수정
	@Override
	public void updateNotice(UpdateNoticeDTO n) throws NotFoundException {

		Optional<Member> writer = memberRepository.findOneById(n.getMemberId());
		
		if(!writer.isPresent()) {
			throw new NotFoundException("존재하지 않는 사용자입니다.");
		}

		if (!writer.get().getId().equals("admin")) {
			throw new NotFoundException("수정 권한이 없는 계정입니다.");
		}

		Optional<Notice> notice = noticeRepository.findOneById(n.getId());

		notice.get().setTitle(n.getTitle());
		notice.get().setContent(n.getContent());
		notice.get().setUpdateDate(n.getUpdateDate());
		notice.get().setIsPriority(n.getIsPriority());

		noticeRepository.save(notice.get());
	}

	// 글삭제
	@Override
	public void deleteNotice(Long id) throws NotFoundException {

		Optional<Notice> notice = noticeRepository.findOneById(id);

		notice.get().setStatus('D');

		noticeRepository.save(notice.get());

	}

}