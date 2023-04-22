package com.jjplanet.ssaibrary.api.member.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import com.jjplanet.ssaibrary.api.member.dto.*;
import com.jjplanet.ssaibrary.api.member.model.Role;
import com.jjplanet.ssaibrary.api.member.model.Token;
import com.jjplanet.ssaibrary.api.member.provider.TokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjplanet.ssaibrary.api.member.domain.Member;
import com.jjplanet.ssaibrary.api.member.repository.MemberCustomRepositoryImpl;
import com.jjplanet.ssaibrary.api.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.common.exception.NotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	private final TokenProvider tokenProvider;
	
	private final MemberCustomRepositoryImpl memberCustomRepository;
	private final S3Service s3Service;

	@Value("${app.auth.refresh-token-expiry}")
	long refreshTokenValidityInMilliseconds;

	// 회원가입
	@Override
	public void joinMember(JoinMemberDTO joinMemberDTO) throws NotFoundException {


		// 아이디 중복 체크
		duplicateId(joinMemberDTO.getId());

		// 닉네임 중복 체크
		duplicateNickname(joinMemberDTO.getNickname());

		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		
		Member member = Member.builder().joinMemberDTO(joinMemberDTO).currentTimestamp(currentTimestamp).build();


		memberRepository.save(member);

	}

	// 아이디 중복 체크
	private void duplicateId(String id) {
		if (memberRepository.findById(id).isPresent()) {
			throw new NotFoundException("중복된 아이디입니다.");
		}
	}

	// 닉네임 중복체크
	private void duplicateNickname(String nickname) {
		if (memberRepository.findByNickname(nickname).isPresent()) {
			throw new NotFoundException("중복된 닉네임입니다.");
		}

	}
	
	//로그인
	@Override
	public LoginDTO loginMember(String id, String password) throws NotFoundException {

		Member loginUser = memberRepository.findByIdAndPassword(id, password).orElseThrow(NotFoundException::new);

		log.debug("로그인 한 사용자 확인해보장 : {}", loginUser);
		
		if(loginUser.getStatus() == 'X') {
			throw new NotFoundException("탈퇴한 회원입니다.");
		}

		Token token = tokenProvider.generateToken(loginUser.getId(), Role.USER.getKey());

		log.debug("일반로그인 토큰 발급했다! {}", token);
		LoginDTO loginDTO = LoginDTO.builder().id(loginUser.getId()).accessToken(token.getAccessToken()).refreshToken(token.getRefreshToken()).name(loginUser.getName()).nickname(loginUser.getNickname()).originImage(loginUser.getOriginImage()).build();



		return loginDTO;
	}
	
	//Account List
	@Override
	public List<MemberDTO> findAllMember() throws NotFoundException {
		return memberRepository.findAll().stream().map(Member::toDTO).collect(Collectors.toList());
	}

	// Account
	@Override
	public MemberDTO findMember(String id) throws NotFoundException  {
		return memberRepository.findById(id).orElseThrow(NotFoundException::new).toDTO();
	}
	
	

	// 회원삭제
	public void deleteMember(DeleteMemberDTO deleteMemberDTO) throws NotFoundException {
		Member member = memberRepository.findById(deleteMemberDTO.getId()).orElseThrow(NotFoundException::new);

		if (member.getStatus() == 'X') {
			throw new NotFoundException("유효한 회원이 아닙니다.");
		}
		member.deleteMember(deleteMemberDTO);

	}

	// 회원정보수정
	public UpdateMemberResDTO updateMember(UpdateMemberDTO updateMemberDTO, MultipartFile multipartFile) throws Exception {
		Member member = memberRepository.findById(updateMemberDTO.getId()).orElseThrow(NotFoundException::new);

		String nickname = member.getNickname();
		String password = member.getPassword();
		String originImage = member.getOriginImage();

		if(!updateMemberDTO.getNickname().equals(nickname)){
			log.debug("닉네임 변경했네");

			// 닉네임 중복 체크
			duplicateNickname(updateMemberDTO.getNickname());
			nickname = updateMemberDTO.getNickname();
		}

		if(!updateMemberDTO.getPassword().equals(password)){
			log.debug("비밀번호 변경했네");

			password = updateMemberDTO.getPassword();
		}

		if(multipartFile != null){
			log.debug("프사 수정했네");
			originImage = s3Service.upload(multipartFile, "profile");
		}


		member.updateMember(nickname, password, originImage);

		return UpdateMemberResDTO.builder().nickname(nickname).originImage(originImage).build();
	}


}