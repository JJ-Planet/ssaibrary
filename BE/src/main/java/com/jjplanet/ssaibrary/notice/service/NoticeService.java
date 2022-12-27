package com.jjplanet.ssaibrary.notice.service;

import java.util.List;

import com.jjplanet.ssaibrary.notice.domain.Notice;
import com.jjplanet.ssaibrary.notice.dto.FindAllNoticeDTO;
import com.jjplanet.ssaibrary.notice.dto.FindOneNoticeByIdDTO;
import com.jjplanet.ssaibrary.notice.dto.InsertNoticeDTO;
import com.jjplanet.ssaibrary.notice.dto.UpdateNoticeDTO;

public interface NoticeService {

	//글작성
	void insertNotice(InsertNoticeDTO n); 

	//전체목록조회
	List<FindAllNoticeDTO> findAllNotice(); 

	//상세조회
	FindOneNoticeByIdDTO findOneNoticeById(Long id);

	//글수정
	void updateNotice(UpdateNoticeDTO n);

	//글삭제
	void deleteNotice(Long id);

}