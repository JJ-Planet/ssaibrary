package com.jjplanet.ssaibrary.notice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.notice.domain.Notice;
import com.jjplanet.ssaibrary.notice.dto.NoticeRequestDTO;
import com.jjplanet.ssaibrary.notice.dto.NoticeResponseDTO;
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
	public void insert(NoticeRequestDTO n) {
		Member writer = memberRepository.findById(n.getMemberId()).get();
		
		n.setStatus('V');
		
		Notice notice = new Notice(writer, n.getTitle(), n.getContent(), n.getRegisterDate(), n.getIsPriority(), n.getStatus());
		
		noticeRepository.save(notice);
	}

	//전체목록조회
	@Override
	public List<NoticeResponseDTO> getAllList() {

		List<Notice> list = noticeCustomRepository.getAllList();
		List<NoticeResponseDTO> outputList = new ArrayList<>();
		

		for(Notice n:list) {
			Member writer = n.getMemberId();
			NoticeResponseDTO output = new NoticeResponseDTO(n.getId(), writer.getId(), n.getTitle(), n.getContent(), n.getHitCount(), n.getRegisterDate(), n.getUpdateDate(), n.getIsPriority(), n.getStatus());
			outputList.add(output);
		}
		
		return outputList;
	}

	//상세조회
	@Override
	public NoticeResponseDTO getOneById(Long id) {
		
		Notice n = noticeCustomRepository.getOneById(id);
		if(n==null) {
			System.out.println("존재 하지 않는 게시글입니다.");
		}
		
		NoticeResponseDTO notice = new NoticeResponseDTO(n.getId(), n.getMemberId().getId(), n.getTitle(), n.getContent(), n.getHitCount(), n.getRegisterDate(), n.getUpdateDate(), n.getIsPriority(), n.getStatus());
		
		return notice;
	}

	//글수정
	@Override
	public void update(Long id, NoticeRequestDTO n) {
		
		Member writer = memberRepository.findById(n.getMemberId()).get();
		
		if(writer==null || !writer.equals("admin")) {
			System.out.println("수정할 수 없습니다.");
		}
		
		Notice notice = noticeCustomRepository.getOneById(id);
		
		notice.setTitle(n.getTitle());
		notice.setContent(n.getContent());
		notice.setUpdateDate(n.getUpdateDate());
		notice.setIsPriority(n.getIsPriority());
		//notice.setStatus(n.getStatus());
		
		noticeRepository.save(notice);
	}

	//글삭제
	@Override
	public void delete(Long id) {
		
		Notice notice = noticeCustomRepository.getOneById(id);
		
		notice.setStatus('D');
		
		noticeRepository.save(notice);
		
		
		
	}
	
	
	

}
