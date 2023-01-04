package com.jjplanet.ssaibrary.community.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjplanet.ssaibrary.community.domain.Community;
import com.jjplanet.ssaibrary.community.dto.FindAllCommunityDTO;
import com.jjplanet.ssaibrary.community.dto.FindOneCommunityByIdDTO;
import com.jjplanet.ssaibrary.community.dto.UpdateCommunityDTO;
import com.jjplanet.ssaibrary.community.dto.insertCommunityDTO;
import com.jjplanet.ssaibrary.community.repository.CommunityRepository;
import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

	private final CommunityRepository communityRepository;
	private final MemberRepository memberRepository;

	// 글작성
	@Override
	public void insertCommunity(insertCommunityDTO c) throws NotFoundException {

		Optional<Member> writer = memberRepository.findByNickname(c.getMemberNickname());

		if (!writer.isPresent()) {
			throw new NotFoundException("존재하지 않는 사용자입니다.");
		}

		// swagger에서 registerDate 값을 입력하면 자꾸 reject해서 임시로 적어놓은 코드
		// start
		Date now = new Date();
		c.setRegisterDate(now);
		// end

		c.setStatus('V');

		Community community = new Community(writer.get(), c.getTitle(), c.getContent(), c.getRegisterDate(),
				c.getStatus());

		communityRepository.save(community);

	}

	// 전체목록조회
	@Override
	public Map<String, Object> findAllCommunity() throws NotFoundException {
		List<Community> list = communityRepository.findAllByStatus('V');
		List<FindAllCommunityDTO> communityList = new ArrayList<>();

		Map<String, Object> result = new HashMap<String, Object>();

		for (Community c : list) {
			FindAllCommunityDTO output = new FindAllCommunityDTO(c.getId(), c.getMemberNickname().getNickname(),
					c.getTitle(), c.getContent(), c.getHitCount(), c.getLikeCount(), c.getRegisterDate(),
					c.getUpdateDate(), c.getStatus());
			communityList.add(output);
		}
		result.put("communityList", communityList);

		return result;
	}

	// 상세조회
	@Override
	public FindOneCommunityByIdDTO findOneCommunityById(Long id) throws NotFoundException {

		Optional<Community> c = communityRepository.findOneById(id);

		if (!c.isPresent()) {
			throw new NotFoundException("존재 하지 않는 게시글입니다.");
		}

		FindOneCommunityByIdDTO community = new FindOneCommunityByIdDTO(c.get().getId(),
				c.get().getMemberNickname().getNickname(), c.get().getTitle(), c.get().getContent(),
				c.get().getHitCount(), c.get().getLikeCount(), c.get().getRegisterDate(), c.get().getUpdateDate(),
				c.get().getStatus());

		return community;
	}

	// 글 수정
	@Override
	public void updateCommunity(UpdateCommunityDTO c) throws NotFoundException {
		Optional<Member> writer = memberRepository.findByNickname(c.getMemberNickname());

		// 수정 버튼을 누른 사용자와 글 작성자가 같은지 확인하는 코드로 바꿀 예정
		if (!writer.isPresent()) {
			throw new NotFoundException();
		}

		Optional<Community> community = communityRepository.findOneById(c.getId());

		community.get().setTitle(c.getTitle());
		community.get().setContent(c.getContent());
		community.get().setUpdateDate(c.getUpdateDate());

		communityRepository.save(community.get());

	}

	// 글 삭제
	@Override
	public void deleteCommunity(Long id) throws NotFoundException {

		Optional<Community> community = communityRepository.findOneById(id);

		community.get().setStatus('D');
		communityRepository.save(community.get());

	}

}
