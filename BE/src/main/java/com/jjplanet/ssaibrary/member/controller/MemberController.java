package com.jjplanet.ssaibrary.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjplanet.ssaibrary.member.dto.DeleteMemberDTO;
import com.jjplanet.ssaibrary.member.dto.FindMemberDTO;
import com.jjplanet.ssaibrary.member.dto.JoinMemberDTO;
import com.jjplanet.ssaibrary.member.dto.UpdateMemberDTO;
import com.jjplanet.ssaibrary.member.service.MemberServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor	
public class MemberController {

	private final MemberServiceImpl memberService;

	//회원가입
	@PostMapping
	public void joinMember(@RequestBody JoinMemberDTO member, HttpSession session) {
		memberService.joinMember(member);
	}

	//Account
	@GetMapping("/{id}")
	public FindMemberDTO findMember(@PathVariable("id") String id) {
		return memberService.findMember(id);
	}

	//회원삭제
	@DeleteMapping("/{id}")
	public DeleteMemberDTO deleteMember(@PathVariable("id") String id) {
		return memberService.deleteMember(id);
	}


	//회원정보수정
	@PutMapping
	public UpdateMemberDTO updateMember(@RequestBody UpdateMemberDTO mydto) {
		return memberService.updateMember(mydto);
	}

}