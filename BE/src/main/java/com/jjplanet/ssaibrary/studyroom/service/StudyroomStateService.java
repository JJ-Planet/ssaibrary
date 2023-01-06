package com.jjplanet.ssaibrary.studyroom.service;

import java.util.List;

import com.jjplanet.ssaibrary.studyroom.dto.StudyroomStateDTO;

public interface StudyroomStateService {

	List<StudyroomStateDTO> findAllStudyroomState();

	StudyroomStateDTO findStudyroomStateById(Long id);

	void insertStudyroomState(StudyroomStateDTO studyroomStateDTO);
}
