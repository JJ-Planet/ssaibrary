package com.jjplanet.ssaibrary.studyroom.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.studyroom.domain.StudyroomReservation;
import com.jjplanet.ssaibrary.studyroom.domain.StudyroomState;
import com.jjplanet.ssaibrary.studyroom.dto.StudyroomStateDTO;
import com.jjplanet.ssaibrary.studyroom.repository.StudyroomReservationRepository;
import com.jjplanet.ssaibrary.studyroom.repository.StudyroomStateRepository;

@Service
public class StudyroomStateServiceImpl implements StudyroomStateService {

	@Autowired
	private StudyroomStateRepository studyroomStateRepository;

	@Autowired
	private StudyroomReservationRepository studyroomReservationRepository;

	@Override
	public List<StudyroomStateDTO> findAllStudyroomState() throws Exception {
		List<StudyroomState> stateList = studyroomStateRepository.findAll();
		List<StudyroomStateDTO> stateDTOList = new LinkedList<>();
		for (StudyroomState ss : stateList) {
			stateDTOList.add(new StudyroomStateDTO(ss.getId(), ss.getStudyroomReservation().getId(), ss.getIsDirty(),
					ss.getIsDamage(), ss.getIsNotLock(), ss.getOriginImage(), ss.getSaveImage()));
		}
		return stateDTOList;
	}

	@Override
	public StudyroomStateDTO findStudyroomStateById(Long id) throws Exception {
		StudyroomState state = studyroomStateRepository.findById(id).orElseThrow(NotFoundException::new);
		StudyroomStateDTO stateDTO = new StudyroomStateDTO(state.getId(), state.getStudyroomReservation().getId(),
				state.getIsDirty(), state.getIsDamage(), state.getIsNotLock(), state.getOriginImage(),
				state.getSaveImage());
		return stateDTO;
	}

	@Override
	public void insertStudyroomState(StudyroomStateDTO studyroomStateDTO) throws Exception {
		StudyroomReservation studyroomReservation = studyroomReservationRepository
				.findById(studyroomStateDTO.getStudyroomReservationID()).orElseThrow(NotFoundException::new);
		StudyroomState studyroomState = new StudyroomState(studyroomStateDTO.getId(), studyroomReservation,
				studyroomStateDTO.getIsDirty(), studyroomStateDTO.getIsDamage(), studyroomStateDTO.getIsNotLock(),
				studyroomStateDTO.getOriginImage(), studyroomStateDTO.getSaveImage());
		studyroomStateRepository.save(studyroomState);
	}
}
