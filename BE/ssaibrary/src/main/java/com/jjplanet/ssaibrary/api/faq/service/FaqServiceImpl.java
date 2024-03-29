package com.jjplanet.ssaibrary.api.faq.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjplanet.ssaibrary.api.faq.domain.Faq;
import com.jjplanet.ssaibrary.api.faq.repository.FaqRepository;
import com.jjplanet.ssaibrary.common.exception.NotFoundException;
import com.jjplanet.ssaibrary.api.faq.dto.FaqDTO;
import com.jjplanet.ssaibrary.api.faq.dto.InsertFaqDTO;
import com.jjplanet.ssaibrary.api.faq.dto.UpdateFaqDTO;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class FaqServiceImpl implements FaqService {

	private final FaqRepository faqRepository;

	// 글 작성
	@Override
	public void insertFaq(InsertFaqDTO insertFaqDTO) throws NotFoundException {
		
		Faq faq = Faq.builder().insertFaqDTO(insertFaqDTO).build();

//		f.setStatus('V');
//
//		Faq faq = new Faq(f.getQuestion(), f.getAnswer(), f.getStatus());

		faqRepository.save(faq);

	}

	// 전체목록조회
	@Override
	public List<FaqDTO> findAllFaq() throws NotFoundException {
		
		return faqRepository.findByStatus('V').stream().map(Faq::toDTO).collect(Collectors.toList());

	}

	// 글 수정
	@Override
	public void updateFaq(UpdateFaqDTO updateFaqDTO) throws NotFoundException {
		
		Faq faq = faqRepository.findById(updateFaqDTO.getId()).orElseThrow(NotFoundException::new);
		
		faq.updateFaq(updateFaqDTO);


	}

	// 글 삭제
	@Override
	public void deleteFaq(Long id) throws NotFoundException {
		
		Faq faq = faqRepository.findById(id).orElseThrow(NotFoundException::new);
		faq.deleteFaq('D');


	}

}
