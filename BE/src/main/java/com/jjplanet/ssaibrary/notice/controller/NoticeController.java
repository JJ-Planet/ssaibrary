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

import com.jjplanet.ssaibrary.member.service.MemberServiceImpl;
import com.jjplanet.ssaibrary.notice.dto.NoticeRequestDTO;
import com.jjplanet.ssaibrary.notice.dto.NoticeResponseDTO;
import com.jjplanet.ssaibrary.notice.service.NoticeServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
	
	private final NoticeServiceImpl noticeService;
	
	//글작성
	@PostMapping("/write")
	public void insert(@RequestBody NoticeRequestDTO notice, HttpSession session) {
		System.out.println(notice.toString());
		
		noticeService.insert(notice);
	}
	
	//전체목록조회
	@GetMapping("/list")
	public List<NoticeResponseDTO> getAllList(){
		return noticeService.getAllList();
	}
	
	//상세조회
	@GetMapping("/get/{id}")
	public NoticeResponseDTO getOneById(@PathVariable("id") Long id) {
		return noticeService.getOneById(id);
	}
	
	//글수정
	@PutMapping("update/{id}")
	public void update(@PathVariable("id")Long id, @RequestBody NoticeRequestDTO n) {
		noticeService.update(id, n);
	}
	
	//글삭제
	@PutMapping("delete/{id}")
	public void delete(@PathVariable("id")Long id) {
		noticeService.delete(id);
	}

}
