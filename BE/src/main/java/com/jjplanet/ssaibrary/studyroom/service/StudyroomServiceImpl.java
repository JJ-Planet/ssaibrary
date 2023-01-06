package com.jjplanet.ssaibrary.studyroom.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.studyroom.domain.Studyroom;
import com.jjplanet.ssaibrary.studyroom.dto.StudyroomDTO;
import com.jjplanet.ssaibrary.studyroom.repository.StudyroomRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class StudyroomServiceImpl implements StudyroomService {

	private final StudyroomRepository studyroomRepository;

	@Override
	public List<StudyroomDTO> findAllStudyroom() {
		return studyroomRepository.findAll().stream().map(Studyroom::toDTO).collect(Collectors.toList());
	}

	@Override
	public StudyroomDTO findStudyroomById(Long id) {
		return studyroomRepository.findById(id).orElseThrow(NotFoundException::new).toDTO();
	}

	@Override
	public void insertStudyroom(StudyroomDTO studyroomDTO) {
		Studyroom studyroom = Studyroom.builder().studyroomDTO(studyroomDTO).build();
		studyroomRepository.save(studyroom);
	}

	@Override
	public void updateStudyroom(StudyroomDTO studyroomDTO) {
		Studyroom studyroom = studyroomRepository.findById(studyroomDTO.getId()).orElseThrow(NotFoundException::new);
		studyroom.updateRoom(studyroomDTO);
	}

	@Override
	public void deleteStudyroom(Long id) {
		studyroomRepository.deleteById(id);
	}
}
