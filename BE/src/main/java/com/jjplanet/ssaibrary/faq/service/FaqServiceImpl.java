package com.jjplanet.ssaibrary.faq.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.faq.domain.Faq;
import com.jjplanet.ssaibrary.faq.dto.FindAllFaqDTO;
import com.jjplanet.ssaibrary.faq.dto.InsertFaqDTO;
import com.jjplanet.ssaibrary.faq.dto.UpdateFaqDTO;
import com.jjplanet.ssaibrary.faq.repository.FaqRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class FaqServiceImpl implements FaqService {

	private final FaqRepository faqRepository;

	// 글 작성
	@Override
	public void insertFaq(InsertFaqDTO f) throws NotFoundException {

		f.setStatus('V');

		Faq faq = new Faq(f.getQuestion(), f.getAnswer(), f.getStatus());

		faqRepository.save(faq);

	}

	// 전체목록조회
	@Override
	public Map<String, Object> findAllFaq() throws NotFoundException {

		List<Faq> list = faqRepository.findAllList();
		List<FindAllFaqDTO> faqList = new ArrayList<>();

		Map<String, Object> result = new HashMap<>();

		for (Faq f : list) {
			FindAllFaqDTO output = new FindAllFaqDTO(f.getId(), f.getQuestion(), f.getAnswer(), f.getStatus());
			faqList.add(output);
		}

		result.put("faqList", faqList);

		return result;
	}

	// 글 수정
	@Override
	public void updateFaq(UpdateFaqDTO f) throws NotFoundException {

		Faq faq = faqRepository.findOneById(f.getId());

		if (faq == null) {
			throw new NotFoundException("존재하지 않는 게시글입니다.");
		}

		faq.setQuestion(f.getQuestion());
		faq.setAnswer(f.getAnswer());

		faqRepository.save(faq);

	}

	// 글 삭제
	@Override
	public void deleteFaq(Long id) throws NotFoundException {

		Faq faq = faqRepository.findOneById(id);

		if (faq == null) {
			throw new NotFoundException("존재하지 않는 게시글입니다.");
		}

		faq.setStatus('D');

		faqRepository.save(faq);

	}

}
