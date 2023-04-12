package com.jjplanet.ssaibrary.api.studyroom.service;

import java.util.List;

import com.jjplanet.ssaibrary.api.studyroom.dto.StudyroomStateDTO;

public interface StudyroomStateService {

	List<StudyroomStateDTO> findAllStudyroomState();

	StudyroomStateDTO findStudyroomStateById(Long id);

	void insertStudyroomState(StudyroomStateDTO studyroomStateDTO);
}
