package com.jjplanet.ssaibrary.inquiry.controller;

import java.util.List;
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
import com.jjplanet.ssaibrary.inquiry.dto.AnswerInquiryDTO;
import com.jjplanet.ssaibrary.inquiry.dto.InquiryDTO;
import com.jjplanet.ssaibrary.inquiry.dto.InsertInquiryDTO;
import com.jjplanet.ssaibrary.inquiry.service.InquiryServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inquiry")
@RequiredArgsConstructor
public class InquiryController {
	
	private static final String SUCCESS = "success";
	
	private final InquiryServiceImpl inquiryService;
	
	//글 작성
	@PostMapping
	public ResponseEntity<String> insertInquiry(@RequestBody InsertInquiryDTO insertInquiryDTO) throws NotFoundException{
		inquiryService.insertInquiry(insertInquiryDTO);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	// 전체목록조회
	@GetMapping
	public ResponseEntity<List<InquiryDTO>> findAllInquiry() throws NotFoundException{
		return new ResponseEntity<List<InquiryDTO>>(inquiryService.findAllInquiry(), HttpStatus.ACCEPTED);
	}
	
	// 상세조회
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> findOneInquiryById(@PathVariable("id") Long id) throws NotFoundException{
		return new ResponseEntity(inquiryService.findOneInquiryById(id), HttpStatus.ACCEPTED);
	}
	
	//답변하기
	@PutMapping
	public ResponseEntity<String> answerInquiry(@RequestBody AnswerInquiryDTO answerInquiryDTO) throws NotFoundException{
		inquiryService.answerInquiry(answerInquiryDTO);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	//글 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteInquiry(@PathVariable("id") Long id) throws NotFoundException{
		inquiryService.deleteInquiry(id);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
}
