package com.jjplanet.ssaibrary.api.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jjplanet.ssaibrary.api.member.dto.*;
import lombok.extern.slf4j.Slf4j;
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

import com.jjplanet.ssaibrary.common.exception.NotFoundException;
import com.jjplanet.ssaibrary.api.member.domain.Member;
import com.jjplanet.ssaibrary.api.member.service.MemberServiceImpl;

import lombok.RequiredArgsConstructor;

@Slf4j
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private static final String SUCCESS = "success";

	private final MemberServiceImpl memberService;

	// 회원가입
	@PostMapping
	public ResponseEntity<String> joinMember(@RequestBody JoinMemberDTO joinMemberDTO)
			throws NotFoundException {

		log.debug("회원가입 정보 들어왔다!! : {}", joinMemberDTO);
		memberService.joinMember(joinMemberDTO);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);

	}
	
	//로그인
	@PostMapping("/login")
	public ResponseEntity<LoginDTO> loginMember(@RequestBody LoginReqDTO loginReqDTO, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws NotFoundException{
		Member loginUser = memberService.loginMember(loginReqDTO.getId(), loginReqDTO.getPassword());
		log.debug("로그인 한 사용자 controller임 : {}", loginUser);

		LoginDTO loginDTO = LoginDTO.builder().id(loginUser.getId()).accessToken("").name(loginUser.getName()).nickname(loginUser.getNickname()).originImage(loginUser.getOriginImage()).build();
		return new ResponseEntity<>(loginDTO, HttpStatus.OK);
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