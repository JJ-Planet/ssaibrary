package com.jjplanet.ssaibrary.community.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjplanet.ssaibrary.community.domain.Community;
import com.jjplanet.ssaibrary.community.dto.CommunityRequestDTO;
import com.jjplanet.ssaibrary.community.repository.CommunityCustomRepositoryImpl;
import com.jjplanet.ssaibrary.community.repository.CommunityRepository;
import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.member.repository.MemberCustomRepositoryImpl;
import com.jjplanet.ssaibrary.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.notice.repository.NoticeCustomRepositoryImpl;
import com.jjplanet.ssaibrary.notice.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService{
	
	private final CommunityRepository communityRepository;
	
//	private final CommunityCustomRepositoryImpl communityCustomRepository;
	
	private final MemberRepository memberRepository;

	//글작성
	@Override
	public void insertCommunity(CommunityRequestDTO c) throws NotFoundException {
		
		Member writer = memberRepository.findByNickname(c.getMemberNickname());
		System.out.println(writer);
		
		c.setStatus('V');
		
		Community community = new Community(writer, c.getTitle(), c.getContent(), c.getRegisterDate(), c.getStatus());
		
		communityRepository.save(community);
		
	}

}
