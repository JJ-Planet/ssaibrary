package com.jjplanet.ssaibrary.api.community.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjplanet.ssaibrary.api.community.dto.CommunityDTO;
import com.jjplanet.ssaibrary.api.community.dto.InsertCommunityDTO;
import com.jjplanet.ssaibrary.api.community.dto.UpdateCommunityDTO;
import com.jjplanet.ssaibrary.api.community.service.CommunityServiceImpl;
import com.jjplanet.ssaibrary.common.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/community")
@RequiredArgsConstructor
public class CommunityController {

	private static final String SUCCESS = "success";

	private final CommunityServiceImpl communityService;

	// 글 작성
	@PostMapping
	public ResponseEntity<String> insertCommunity(@RequestBody InsertCommunityDTO insertCommunityDTO, HttpSession session)
			throws NotFoundException {
		communityService.insertCommunity(insertCommunityDTO);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	// 전체목록조회
	@GetMapping
	public ResponseEntity<List<CommunityDTO>> findAllCommunity() throws NotFoundException {
		return new ResponseEntity<List<CommunityDTO>>(communityService.findAllCommunity(), HttpStatus.ACCEPTED);
	}

	// 상세조회
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> findOneCommunityById(@PathVariable("id") Long id)
			throws NotFoundException {
		return new ResponseEntity(communityService.findOneCommunityById(id), HttpStatus.ACCEPTED);
	}

	// 글 수정
	@PutMapping
	public ResponseEntity<String> updateCommunity(@RequestBody UpdateCommunityDTO updateCommunityDTO) throws NotFoundException {
		communityService.updateCommunity(updateCommunityDTO);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);

	}

	// 글 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCommunity(@PathVariable("id") Long id) throws NotFoundException {
		communityService.deleteCommunity(id);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

}
