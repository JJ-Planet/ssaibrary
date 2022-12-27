package com.jjplanet.ssaibrary.notice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class NoticeServiceImpl implements NoticeService{

	private final NoticeRepository noticeRepository;
	private final NoticeCustomRepositoryImpl noticeCustomRepository;
	private final MemberRepository memberRepository;

	//글작성
	@Override
	public void insertNotice(InsertNoticeDTO n) throws NotFoundException{
		Member writer = memberRepository.findOneById(n.getMemberId()).orElseThrow(NotFoundException::new);

		n.setStatus('V');

		Notice notice = new Notice(writer, n.getTitle(), n.getContent(), n.getRegisterDate(), n.getIsPriority(), n.getStatus());

		noticeRepository.save(notice);
	}

	//전체목록조회
	@Override
	public Map<String, Object> findAllNotice() throws NotFoundException {

		List<Notice> list = noticeCustomRepository.findAllList();
		List<FindAllNoticeDTO> noticeList = new ArrayList<>();

		Map<String, Object> result = new HashMap<String, Object>();

		for(Notice n:list) {
			FindAllNoticeDTO output = new FindAllNoticeDTO(n.getId(), n.getMemberId().getId(), n.getTitle(), n.getContent(), n.getHitCount(), n.getRegisterDate(), n.getUpdateDate(), n.getIsPriority(), n.getStatus());
			noticeList.add(output);
		}
		result.put("noticeList", noticeList);

		return result;
	}

	//상세조회
	@Override
	public FindOneNoticeByIdDTO findOneNoticeById(Long id) throws NotFoundException {

		Notice n = noticeCustomRepository.findOneById(id);
		if(n==null) {
			throw new NotFoundException("존재 하지 않는 게시글입니다.");
		}

		FindOneNoticeByIdDTO notice = new FindOneNoticeByIdDTO(n.getId(), n.getMemberId().getId(), n.getTitle(), n.getContent(), n.getHitCount(), n.getRegisterDate(), n.getUpdateDate(), n.getIsPriority(), n.getStatus());

		return notice;
	}

	//글수정
	@Override
	public void updateNotice(UpdateNoticeDTO n) throws NotFoundException {

		Member writer = memberRepository.findOneById(n.getMemberId()).orElseThrow(NotFoundException::new);

		if(!writer.equals("admin")) {
			throw new NotFoundException("수정 권한이 없는 계정입니다.");
		}
		

		Notice notice = noticeCustomRepository.findOneById(n.getId());

		notice.setTitle(n.getTitle());
		notice.setContent(n.getContent());
		notice.setUpdateDate(n.getUpdateDate());
		notice.setIsPriority(n.getIsPriority());

		noticeRepository.save(notice);
	}

	//글삭제
	@Override
	public void deleteNotice(Long id) throws NotFoundException {

		Notice notice = noticeCustomRepository.findOneById(id);

		notice.setStatus('D');

		noticeRepository.save(notice);



	}




}