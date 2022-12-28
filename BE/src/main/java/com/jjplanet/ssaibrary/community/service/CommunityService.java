package com.jjplanet.ssaibrary.community.service;

import java.util.Map;

import com.jjplanet.ssaibrary.community.dto.FindOneCommunityByIdDTO;
import com.jjplanet.ssaibrary.community.dto.UpdateCommunityDTO;
import com.jjplanet.ssaibrary.community.dto.insertCommunityDTO;
import com.jjplanet.ssaibrary.exception.NotFoundException;

public interface CommunityService {

	// 글작성
	void insertCommunity(insertCommunityDTO c) throws NotFoundException;

	// 전체목록조회
	Map<String, Object> findAllCommunity() throws NotFoundException;

	// 상세조회
	FindOneCommunityByIdDTO findOneCommunityById(Long id) throws NotFoundException;

	// 글 수정
	void updateCommunity(UpdateCommunityDTO c) throws NotFoundException;

	// 글 삭제
	void deleteCommunity(Long id) throws NotFoundException;

}
