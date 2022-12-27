package com.jjplanet.ssaibrary.member.controller;

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
import com.jjplanet.ssaibrary.member.dto.FindMemberDTO;
import com.jjplanet.ssaibrary.member.dto.JoinMemberDTO;
import com.jjplanet.ssaibrary.member.dto.UpdateMemberDTO;
import com.jjplanet.ssaibrary.member.service.MemberServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private static final String SUCCESS = "success";

	private final MemberServiceImpl memberService;

	// 회원가입
	@PostMapping
	public ResponseEntity<String> joinMember(@RequestBody JoinMemberDTO member, HttpSession session)
			throws NotFoundException {

		memberService.joinMember(member);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);

	}

	// Account
	@GetMapping("/{id}")
	public FindMemberDTO findMember(@PathVariable("id") String id) throws NotFoundException {
		return memberService.findMember(id);
	}

	// 회원삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMember(@PathVariable("id") String id) throws NotFoundException {
		memberService.deleteMember(id);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	// 회원정보수정
	@PutMapping
	public ResponseEntity<String> updateMember(@RequestBody UpdateMemberDTO m) throws NotFoundException {
		memberService.updateMember(m);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

}