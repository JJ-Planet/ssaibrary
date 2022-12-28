package com.jjplanet.ssaibrary.community.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.jjplanet.ssaibrary.member.repository.MemberCustomRepositoryImpl;
import com.jjplanet.ssaibrary.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.notice.domain.Notice;
import com.jjplanet.ssaibrary.notice.dto.FindAllNoticeDTO;
import com.jjplanet.ssaibrary.notice.dto.FindOneNoticeByIdDTO;
import com.jjplanet.ssaibrary.notice.repository.NoticeCustomRepositoryImpl;
import com.jjplanet.ssaibrary.notice.repository.NoticeRepository;

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

		Member writer = memberRepository.findByNickname(c.getMemberNickname());

		// swagger에서 registerDate 값을 입력하면 자꾸 reject해서 임시로 적어놓은 코드
		// start
		Date now = new Date();
		c.setRegisterDate(now);
		// end

		c.setStatus('V');

		Community community = new Community(writer, c.getTitle(), c.getContent(), c.getRegisterDate(), c.getStatus());

		communityRepository.save(community);

	}

	// 전체목록조회
	@Override
	public Map<String, Object> findAllCommunity() throws NotFoundException {
		List<Community> list = communityRepository.findAllList();
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

		Community c = communityRepository.findOneById(id);

		if (c == null) {
			throw new NotFoundException("존재 하지 않는 게시글입니다.");
		}

		FindOneCommunityByIdDTO community = new FindOneCommunityByIdDTO(c.getId(), c.getMemberNickname().getNickname(),
				c.getTitle(), c.getContent(), c.getHitCount(), c.getLikeCount(), c.getRegisterDate(), c.getUpdateDate(),
				c.getStatus());

		return community;
	}

	// 글 수정
	@Override
	public void updateCommunity(UpdateCommunityDTO c) throws NotFoundException {
		Member writer = memberRepository.findByNickname(c.getMemberNickname());

		// 수정 버튼을 누른 사용자와 글 작성자가 같은지 확인하는 코드로 바꿀 예정
		if (writer == null) {
			throw new NotFoundException();
		}

		Community community = communityRepository.findOneById(c.getId());

		community.setTitle(c.getTitle());
		community.setContent(c.getContent());
		community.setUpdateDate(c.getUpdateDate());

		communityRepository.save(community);

	}

	// 글 삭제
	@Override
	public void deleteCommunity(Long id) throws NotFoundException {

		Community community = communityRepository.findOneById(id);

		community.setStatus('D');
		communityRepository.save(community);

	}

}
