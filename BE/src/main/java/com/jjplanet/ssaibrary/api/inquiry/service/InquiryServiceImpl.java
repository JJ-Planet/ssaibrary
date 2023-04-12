package com.jjplanet.ssaibrary.api.inquiry.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjplanet.ssaibrary.api.inquiry.dto.AnswerInquiryDTO;
import com.jjplanet.ssaibrary.api.inquiry.dto.InquiryDTO;
import com.jjplanet.ssaibrary.api.inquiry.dto.InsertInquiryDTO;
import com.jjplanet.ssaibrary.api.inquiry.repository.InquiryRepository;
import com.jjplanet.ssaibrary.api.member.domain.Member;
import com.jjplanet.ssaibrary.api.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.common.exception.NotFoundException;
import com.jjplanet.ssaibrary.api.inquiry.domain.Inquiry;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class InquiryServiceImpl implements InquiryService {

	private final InquiryRepository inquiryRepository;
	private final MemberRepository memberRepository;

	// 글 작성
	@Override
	public void insertInquiry(InsertInquiryDTO insertInquiryDTO) throws NotFoundException {

		Member member = memberRepository.findByNickname(insertInquiryDTO.getMemberNickname()).orElseThrow(NotFoundException::new);

		Inquiry inquiry = Inquiry.builder().insertInquiryDTO(insertInquiryDTO).member(member).build();

		inquiryRepository.save(inquiry);
	}

	// 전체목록조회
	@Override
	public List<InquiryDTO> findAllInquiry() throws NotFoundException {
		
		return inquiryRepository.findAll().stream().map(Inquiry::toDTO).collect(Collectors.toList());

	}

	// 상세조회
	@Override
	public InquiryDTO findOneInquiryById(Long id) throws NotFoundException {
		
		return inquiryRepository.findById(id).orElseThrow(NotFoundException::new).toDTO();
	}

	// 답변하기
	@Override
	public void answerInquiry(AnswerInquiryDTO answerInquiryDTO) throws NotFoundException {
		
		Inquiry inquiry = inquiryRepository.findById(answerInquiryDTO.getId()).orElseThrow(NotFoundException::new);
		
		Member member = memberRepository.findByNickname(answerInquiryDTO.getMemberNickname()).orElseThrow(NotFoundException::new);
		
		if(member.getIsAdmin()=='N') {
			throw new NotFoundException("답변 권한이 없는 회원입니다.");
		}
		
		inquiry.anserInquiry(answerInquiryDTO);

	}

	// 글 삭제
	@Override
	public void deleteInquiry(Long id) throws NotFoundException {
		
		Inquiry inquiry = inquiryRepository.findById(id).orElseThrow(NotFoundException::new);
		
		inquiry.deleteInquiry('D');

	}

}
