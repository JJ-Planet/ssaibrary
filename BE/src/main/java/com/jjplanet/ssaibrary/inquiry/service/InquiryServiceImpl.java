package com.jjplanet.ssaibrary.inquiry.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.inquiry.domain.Inquiry;
import com.jjplanet.ssaibrary.inquiry.dto.AnswerInquiryDTO;
import com.jjplanet.ssaibrary.inquiry.dto.FindAllInquiryDTO;
import com.jjplanet.ssaibrary.inquiry.dto.FindOneInquiryByIdDTO;
import com.jjplanet.ssaibrary.inquiry.dto.InsertInquiryDTO;
import com.jjplanet.ssaibrary.inquiry.repository.InquiryRepository;
import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class InquiryServiceImpl implements InquiryService {

	private final InquiryRepository inquiryRepository;
	private final MemberRepository memberRepository;

	// 글 작성
	@Override
	public void insertInquiry(InsertInquiryDTO i) throws NotFoundException {

		Optional<Member> writer = memberRepository.findByNickname(i.getMemberNickname());

		if (!writer.isPresent()) {
			throw new NotFoundException("존재하지 않는 사용자입니다.");
		}

		i.setStatus('W');

		Inquiry inquiry = new Inquiry(writer.get(), i.getTitle(), i.getQuestion(), i.getRegisterDate(), i.getStatus());

		inquiryRepository.save(inquiry);
	}

	// 전체목록조회
	@Override
	public Map<String, Object> findAllInquiry() throws NotFoundException {

		List<Inquiry> list = inquiryRepository.findAllList();
		List<FindAllInquiryDTO> inquiryList = new ArrayList<>();

		Map<String, Object> result = new HashMap<>();

		for (Inquiry i : list) {
			FindAllInquiryDTO output = new FindAllInquiryDTO(i.getId(), i.getMemberNickname().getNickname(),
					i.getTitle(), i.getQuestion(), i.getAnswer(), i.getRegisterDate(), i.getStatus());
			inquiryList.add(output);
		}

		result.put("inquiryList", inquiryList);

		return result;
	}

	// 상세조회
	@Override
	public FindOneInquiryByIdDTO findOneInquiryById(Long id) throws NotFoundException {

		Optional<Inquiry> i = inquiryRepository.findOneById(id);

		if (!i.isPresent()) {
			throw new NotFoundException("존재하지 않는 게시글 입니다.");
		}

		FindOneInquiryByIdDTO inquiry = new FindOneInquiryByIdDTO(i.get().getId(),
				i.get().getMemberNickname().getNickname(), i.get().getTitle(), i.get().getQuestion(),
				i.get().getAnswer(), i.get().getRegisterDate(), i.get().getStatus());

		return inquiry;
	}

	// 답변하기
	@Override
	public void answerInquiry(AnswerInquiryDTO i) throws NotFoundException {

		Optional<Inquiry> inquiry = inquiryRepository.findOneById(i.getId());

		inquiry.get().setAnswer(i.getAnswer());
		inquiry.get().setStatus('C');

		inquiryRepository.save(inquiry.get());

	}

	// 글 삭제
	@Override
	public void deleteInquiry(Long id) throws NotFoundException {

		Optional<Inquiry> inquiry = inquiryRepository.findOneById(id);

		inquiry.get().setStatus('D');

		inquiryRepository.save(inquiry.get());

	}

}
