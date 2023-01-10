package com.jjplanet.ssaibrary.faq.service;

import java.util.List;
import java.util.Map;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.faq.dto.FaqDTO;
import com.jjplanet.ssaibrary.faq.dto.InsertFaqDTO;
import com.jjplanet.ssaibrary.faq.dto.UpdateFaqDTO;

public interface FaqService {

	// 글 작성
	void insertFaq(InsertFaqDTO insertFaqDTO) throws NotFoundException;

	// 전체 목록 불러오기
	List<FaqDTO> findAllFaq() throws NotFoundException;

	// 글 수정
	void updateFaq(UpdateFaqDTO updateFaqDTO) throws NotFoundException;

	// 글 삭제
	void deleteFaq(Long id) throws NotFoundException;

}
