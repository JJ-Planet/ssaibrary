package com.jjplanet.ssaibrary.api.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jjplanet.ssaibrary.api.member.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jjplanet.ssaibrary.common.exception.NotFoundException;
import com.jjplanet.ssaibrary.api.member.domain.Member;
import com.jjplanet.ssaibrary.api.member.service.MemberServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/api/v1/member")
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
		LoginDTO loginDTO = memberService.loginMember(loginReqDTO.getId(), loginReqDTO.getPassword());
		log.debug("로그인 한 사용자 controller임 : {}", loginDTO);

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
	@PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<UpdateMemberResDTO> updateMember(@RequestPart("memberInfo") UpdateMemberDTO updateMemberDTO, @RequestPart(value = "profileImg", required = false) MultipartFile multipartFile) throws Exception {
		UpdateMemberResDTO updateMemberResDTO = memberService.updateMember(updateMemberDTO, multipartFile);
		return new ResponseEntity<>(updateMemberResDTO, HttpStatus.OK);
	}

}