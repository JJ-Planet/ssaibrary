package com.jjplanet.ssaibrary.api.community.service;

import java.util.List;

import com.jjplanet.ssaibrary.api.community.dto.CommunityDTO;
import com.jjplanet.ssaibrary.api.community.dto.InsertCommunityDTO;
import com.jjplanet.ssaibrary.api.community.dto.UpdateCommunityDTO;
import com.jjplanet.ssaibrary.common.exception.NotFoundException;

public interface CommunityService {

	// 글작성
	void insertCommunity(InsertCommunityDTO insertCommunityDTO) throws NotFoundException;

	// 전체목록조회
	List<CommunityDTO> findAllCommunity() throws NotFoundException;

	// 상세조회
	CommunityDTO findOneCommunityById(Long id) throws NotFoundException;

	// 글 수정
	void updateCommunity(UpdateCommunityDTO updateCommunityDTO) throws NotFoundException;

	// 글 삭제
	void deleteCommunity(Long id) throws NotFoundException;

}
