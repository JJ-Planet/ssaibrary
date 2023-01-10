package com.jjplanet.ssaibrary.inquiry.service;

import java.util.List;
import java.util.Map;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.inquiry.dto.AnswerInquiryDTO;
import com.jjplanet.ssaibrary.inquiry.dto.FindOneInquiryByIdDTO;
import com.jjplanet.ssaibrary.inquiry.dto.InquiryDTO;
import com.jjplanet.ssaibrary.inquiry.dto.InsertInquiryDTO;

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
