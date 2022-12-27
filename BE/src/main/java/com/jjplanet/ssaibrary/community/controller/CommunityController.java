package com.jjplanet.ssaibrary.community.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjplanet.ssaibrary.community.dto.CommunityRequestDTO;
import com.jjplanet.ssaibrary.community.service.CommunityServiceImpl;
import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.notice.service.NoticeServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {
	
	private static final String SUCCESS = "success";
	
	@Autowired
	private final CommunityServiceImpl communityService;
	
	@PostMapping
	public ResponseEntity<String> insertCommunity(CommunityRequestDTO community, HttpSession session) throws NotFoundException {
		communityService.insertCommunity(community);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

}
