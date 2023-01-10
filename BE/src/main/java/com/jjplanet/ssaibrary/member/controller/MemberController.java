package com.jjplanet.ssaibrary.member.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.member.dto.DeleteMemberDTO;
import com.jjplanet.ssaibrary.member.dto.FindMemberDTO;
import com.jjplanet.ssaibrary.member.dto.JoinMemberDTO;
import com.jjplanet.ssaibrary.member.dto.LoginDTO;
import com.jjplanet.ssaibrary.member.dto.MemberDTO;
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
	
	//로그인
	@PostMapping("/login")
	public Member loginMember(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session) throws NotFoundException{
		Member loginUser = memberService.loginMember(id, password); 
		session.setAttribute("loginUser", loginUser);
		return loginUser;
	}
	
	//로그아웃
	@GetMapping("/logout")
	public ResponseEntity<String> logoutMember(HttpSession session){
		session.invalidate();
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	//Account List
	@GetMapping
	public ResponseEntity<List<MemberDTO>> findAllMember() throws NotFoundException{
		return new ResponseEntity<List<MemberDTO>>(memberService.findAllMember(), HttpStatus.ACCEPTED);
	}

	// Account
	@GetMapping("/{id}")
	public MemberDTO findMember(@PathVariable("id") String id) throws NotFoundException {
		return memberService.findMember(id);
	}

	// 회원삭제
	@DeleteMapping
	public ResponseEntity<String> deleteMember(@RequestBody DeleteMemberDTO deleteMemberDTO) throws NotFoundException {
		memberService.deleteMember(deleteMemberDTO);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	// 회원정보수정
	@PutMapping
	public ResponseEntity<String> updateMember(@RequestBody UpdateMemberDTO updateMemberDTO) throws NotFoundException {
		memberService.updateMember(updateMemberDTO);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

}