package com.jjplanet.ssaibrary.inquiry.service;

import java.util.Map;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.inquiry.dto.AnswerInquiryDTO;
import com.jjplanet.ssaibrary.inquiry.dto.FindOneInquiryByIdDTO;
import com.jjplanet.ssaibrary.inquiry.dto.InsertInquiryDTO;

public interface InquiryService {
	
	//글 작성
	void insertInquiry(InsertInquiryDTO i) throws NotFoundException;
	
	//전체목록조회
	Map<String, Object> findAllInquiry() throws NotFoundException;
	
	//상세조회
	FindOneInquiryByIdDTO findOneInquiryById(Long id) throws NotFoundException;
	
	//답변하기
	void answerInquiry(AnswerInquiryDTO i) throws NotFoundException;
	
	//글 삭제
	void deleteInquiry(Long id) throws NotFoundException;

}
