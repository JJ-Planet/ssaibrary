package com.jjplanet.ssaibrary.faq.service;

import java.util.Map;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.faq.dto.InsertFaqDTO;
import com.jjplanet.ssaibrary.faq.dto.UpdateFaqDTO;

public interface FaqService {

	// 글 작성
	void insertFaq(InsertFaqDTO f) throws NotFoundException;

	// 전체 목록 불러오기
	Map<String, Object> findAllFaq() throws NotFoundException;

	// 글 수정
	void updateFaq(UpdateFaqDTO f) throws NotFoundException;

	// 글 삭제
	void deleteFaq(Long id) throws NotFoundException;

}
