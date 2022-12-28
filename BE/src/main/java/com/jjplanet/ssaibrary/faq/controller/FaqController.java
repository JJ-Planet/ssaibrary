package com.jjplanet.ssaibrary.faq.controller;

import java.util.Map;

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

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.faq.dto.InsertFaqDTO;
import com.jjplanet.ssaibrary.faq.dto.UpdateFaqDTO;
import com.jjplanet.ssaibrary.faq.repository.FaqRepository;
import com.jjplanet.ssaibrary.faq.service.FaqServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/faq")
@RequiredArgsConstructor
public class FaqController {

	private static final String SUCCESS = "success";

	private final FaqServiceImpl faqService;

	// 글 작성
	@PostMapping
	public ResponseEntity<String> insertFaq(@RequestBody InsertFaqDTO f) throws NotFoundException {
		faqService.insertFaq(f);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	// 전체목록조회
	@GetMapping
	public ResponseEntity<Map<String, Object>> findAllFaq() throws NotFoundException {
		return new ResponseEntity<Map<String, Object>>(faqService.findAllFaq(), HttpStatus.ACCEPTED);
	}

	// 글 수정
	@PutMapping
	public ResponseEntity<String> updateFaq(@RequestBody UpdateFaqDTO f) throws NotFoundException {
		faqService.updateFaq(f);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	// 글 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFaq(@PathVariable("id") Long id) throws NotFoundException {
		faqService.deleteFaq(id);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

}
