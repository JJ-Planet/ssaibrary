package com.jjplanet.ssaibrary.community.service;

import com.jjplanet.ssaibrary.community.dto.CommunityRequestDTO;
import com.jjplanet.ssaibrary.exception.NotFoundException;

public interface CommunityService {
	
	//글작성
	void insertCommunity(CommunityRequestDTO c) throws NotFoundException;

}
