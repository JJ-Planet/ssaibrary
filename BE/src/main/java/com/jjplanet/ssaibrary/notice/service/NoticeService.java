package com.jjplanet.ssaibrary.notice.service;

import java.util.List;

import com.jjplanet.ssaibrary.notice.domain.Notice;
import com.jjplanet.ssaibrary.notice.dto.FindAllNoticeDTO;
import com.jjplanet.ssaibrary.notice.dto.InsertNoticeDTO;
import com.jjplanet.ssaibrary.notice.dto.NoticeRequestDTO;

public interface NoticeService {

	//글작성
	void insertNotice(InsertNoticeDTO n); 

	//전체목록조회
	List<FindAllNoticeDTO> findAllNotice(); 

	//상세조회
	//NoticeResponseDTO getOneById(Long id);

	//글수정
	void update(Long id, NoticeRequestDTO n);

	//글삭제
	void delete(Long id);

}