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

import com.jjplanet.ssaibrary.member.dto.MemberRequestDTO;
import com.jjplanet.ssaibrary.member.dto.MemberResponseDTO;
import com.jjplanet.ssaibrary.member.service.MemberServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor	
public class MemberController {
	
	private final MemberServiceImpl memberService;
	
	//회원가입
	@PostMapping("/join")
	public void join(@RequestBody MemberRequestDTO member, HttpSession session) {
		//System.out.println(member.toString());
		memberService.join(member);
	}
	
	//Account
	@GetMapping("/account/{id}")
	public MemberResponseDTO getInfo(@PathVariable("id") String id) {
		return memberService.getInfo(id);
	}
	
//	//회원삭제 - 연습용
//	@DeleteMapping("/delete/{id}")
//	public void deleteById(@PathVariable("id") String id) {
//		memberService.deleteById(id);
//	}
	
	//진짜회원삭제
	@PutMapping("/delete/{id}")
	public MemberRequestDTO deleteMember(@PathVariable("id") String id) {
		return memberService.deleteMember(id);
	}

	
	//회원정보수정
	@PutMapping("/update")
	public MemberRequestDTO updateMember(@RequestBody MemberRequestDTO mydto) {
		
		return memberService.updateMember(mydto);
		
	}

}
