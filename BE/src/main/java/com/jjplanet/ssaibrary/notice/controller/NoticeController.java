package com.jjplanet.ssaibrary.notice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjplanet.ssaibrary.notice.dto.FindAllNoticeDTO;
import com.jjplanet.ssaibrary.notice.dto.FindOneNoticeByIdDTO;
import com.jjplanet.ssaibrary.notice.dto.InsertNoticeDTO;
import com.jjplanet.ssaibrary.notice.dto.UpdateNoticeDTO;
import com.jjplanet.ssaibrary.notice.service.NoticeServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

	private final NoticeServiceImpl noticeService;

	//글작성
	@PostMapping
	public void insertNotice(@RequestBody InsertNoticeDTO notice, HttpSession session) {
		noticeService.insertNotice(notice);
	}

	//전체목록조회
	@GetMapping
	public List<FindAllNoticeDTO> findAllNotice(){
		return noticeService.findAllNotice();
	}

	//상세조회
	@GetMapping("/{id}")
	public FindOneNoticeByIdDTO findOneNoticeById(@PathVariable("id") Long id) {
		return noticeService.findOneNoticeById(id);
	}

	//글수정
	@PutMapping
	public void updateNotice(@RequestBody UpdateNoticeDTO n) {
		noticeService.updateNotice(n);
	}

	//글삭제
	@PutMapping("delete/{id}")
	public void delete(@PathVariable("id")Long id) {
		noticeService.delete(id);
	}

}