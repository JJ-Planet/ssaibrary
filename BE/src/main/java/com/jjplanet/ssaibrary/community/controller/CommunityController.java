package com.jjplanet.ssaibrary.community.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjplanet.ssaibrary.community.dto.CommunityRequestDTO;
import com.jjplanet.ssaibrary.community.service.CommunityServiceImpl;
import com.jjplanet.ssaibrary.notice.service.NoticeServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {
	
//	private final CommunityServiceImpl communityService;
	
//	@PostMapping("write")
//	public void insert(CommunityRequestDTO community, HttpSession session) {
//		communityService.insert(community);
//	}

}
