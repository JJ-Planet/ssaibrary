package com.jjplanet.ssaibrary.api.inquiry.service;

import java.util.List;

import com.jjplanet.ssaibrary.api.inquiry.dto.AnswerInquiryDTO;
import com.jjplanet.ssaibrary.api.inquiry.dto.InquiryDTO;
import com.jjplanet.ssaibrary.common.exception.NotFoundException;
import com.jjplanet.ssaibrary.api.inquiry.dto.InsertInquiryDTO;

public interface InquiryService {
	
	//글 작성
	void insertInquiry(InsertInquiryDTO insertInquiryDTO) throws NotFoundException;
	
	//전체목록조회
	List<InquiryDTO> findAllInquiry() throws NotFoundException;
	
	//상세조회
	InquiryDTO findOneInquiryById(Long id) throws NotFoundException;
	
	//답변하기
	void answerInquiry(AnswerInquiryDTO answerInquiryDTO) throws NotFoundException;
	
	//글 삭제
	void deleteInquiry(Long id) throws NotFoundException;

}
