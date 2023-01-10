package com.jjplanet.ssaibrary.notice.controller;

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

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.notice.dto.FindAllNoticeDTO;
import com.jjplanet.ssaibrary.notice.dto.InsertNoticeDTO;
import com.jjplanet.ssaibrary.notice.dto.NoticeDTO;
import com.jjplanet.ssaibrary.notice.dto.UpdateNoticeDTO;
import com.jjplanet.ssaibrary.notice.service.NoticeServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
	
	private static final String SUCCESS = "success";

	private final NoticeServiceImpl noticeService;

	//글작성
	@PostMapping
	public ResponseEntity<String> insertNotice(@RequestBody InsertNoticeDTO insertNoticeDTO, HttpSession session) throws NotFoundException {
		noticeService.insertNotice(insertNoticeDTO);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	//전체목록조회
	@GetMapping
	public ResponseEntity<List<NoticeDTO>> findAllNotice() throws NotFoundException{
		return new ResponseEntity<List<NoticeDTO>>(noticeService.findAllNotice(), HttpStatus.ACCEPTED);
	}

	//상세조회
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> findOneNoticeById(@PathVariable("id") Long id) throws NotFoundException {
		return new ResponseEntity(noticeService.findOneNoticeById(id), HttpStatus.ACCEPTED);
	}

	//글수정
	@PutMapping
	public ResponseEntity<String> updateNotice(@RequestBody UpdateNoticeDTO updateNoticeDTO) throws NotFoundException {
		noticeService.updateNotice(updateNoticeDTO);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	//글삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteNotice(@PathVariable("id")Long id) throws NotFoundException {
		noticeService.deleteNotice(id);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

}