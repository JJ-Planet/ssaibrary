package com.jjplanet.ssaibrary.api.community.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjplanet.ssaibrary.api.community.domain.Community;
import com.jjplanet.ssaibrary.api.community.repository.CommunityRepository;
import com.jjplanet.ssaibrary.api.member.domain.Member;
import com.jjplanet.ssaibrary.api.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.api.community.dto.CommunityDTO;
import com.jjplanet.ssaibrary.api.community.dto.InsertCommunityDTO;
import com.jjplanet.ssaibrary.api.community.dto.UpdateCommunityDTO;
import com.jjplanet.ssaibrary.common.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

	private final CommunityRepository communityRepository;
	private final MemberRepository memberRepository;

	// 글작성
	@Override
	public void insertCommunity(InsertCommunityDTO insertCommunityDTO) throws NotFoundException {
		
		Member member = memberRepository.findByNickname(insertCommunityDTO.getMemberNickname()).orElseThrow(NotFoundException::new);
		
		Community community = Community.builder().insertCommunityDTO(insertCommunityDTO).member(member).build();
		
		communityRepository.save(community);


	}

	// 전체목록조회
	@Override
	public List<CommunityDTO> findAllCommunity() throws NotFoundException {

		return communityRepository.findByStatus('V').stream().map(Community::toDTO).collect(Collectors.toList());
	}

	// 상세조회
	@Override
	public CommunityDTO findOneCommunityById(Long id) throws NotFoundException {
		
		return communityRepository.findById(id).orElseThrow(NotFoundException::new).toDTO();

	}

	// 글 수정
	@Override
	public void updateCommunity(UpdateCommunityDTO updateCommunityDTO) throws NotFoundException {
		
		Community community = communityRepository.findById(updateCommunityDTO.getId()).orElseThrow(NotFoundException::new);
		
		community.updateCommunity(updateCommunityDTO);

	}

	// 글 삭제
	@Override
	public void deleteCommunity(Long id) throws NotFoundException {
		
		Community community = communityRepository.findById(id).orElseThrow(NotFoundException::new);

		community.deleteCommunity('D');

	}

}
