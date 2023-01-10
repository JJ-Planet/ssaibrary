package com.jjplanet.ssaibrary.notice.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.notice.domain.Notice;
import com.jjplanet.ssaibrary.notice.dto.FindAllNoticeDTO;
import com.jjplanet.ssaibrary.notice.dto.InsertNoticeDTO;
import com.jjplanet.ssaibrary.notice.dto.NoticeDTO;
import com.jjplanet.ssaibrary.notice.dto.UpdateNoticeDTO;

public interface NoticeService {

	//글작성
	void insertNotice(InsertNoticeDTO insertNoticeDTO) throws NotFoundException; 

	//전체목록조회
	List<NoticeDTO> findAllNotice() throws NotFoundException; 

	//상세조회
	NoticeDTO findOneNoticeById(Long id) throws NotFoundException;

	//글수정
	void updateNotice(UpdateNoticeDTO updateNoticeDTO) throws NotFoundException;

	//글삭제
	void deleteNotice(Long id) throws NotFoundException;

}