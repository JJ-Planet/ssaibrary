package com.jjplanet.ssaibrary.api.studyroom.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jjplanet.ssaibrary.api.studyroom.repository.StudyroomReservationRepository;
import com.jjplanet.ssaibrary.api.studyroom.repository.StudyroomStateRepository;
import com.jjplanet.ssaibrary.common.exception.NotFoundException;
import com.jjplanet.ssaibrary.api.studyroom.domain.StudyroomReservation;
import com.jjplanet.ssaibrary.api.studyroom.domain.StudyroomState;
import com.jjplanet.ssaibrary.api.studyroom.dto.StudyroomStateDTO;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class StudyroomStateServiceImpl implements StudyroomStateService {

	private final StudyroomStateRepository studyroomStateRepository;

	private final StudyroomReservationRepository studyroomReservationRepository;

	@Override
	public List<StudyroomStateDTO> findAllStudyroomState() {
		return studyroomStateRepository.findAll().stream().map(StudyroomState::toDTO).collect(Collectors.toList());
	}

	@Override
	public StudyroomStateDTO findStudyroomStateById(Long id) {
		return studyroomStateRepository.findById(id).orElseThrow(NotFoundException::new).toDTO();
	}

	@Override
	public void insertStudyroomState(StudyroomStateDTO studyroomStateDTO) {
		StudyroomReservation studyroomReservation = studyroomReservationRepository
				.findById(studyroomStateDTO.getStudyroomReservationID()).orElseThrow(NotFoundException::new);
		StudyroomState studyroomState = StudyroomState.builder().studyroomStateDTO(studyroomStateDTO).studyroomReservation(studyroomReservation).build();
		studyroomStateRepository.save(studyroomState);
	}
}
