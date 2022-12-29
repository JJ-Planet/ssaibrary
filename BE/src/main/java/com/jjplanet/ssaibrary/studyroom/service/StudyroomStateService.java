package com.jjplanet.ssaibrary.studyroom.service;

import java.util.List;

import com.jjplanet.ssaibrary.studyroom.dto.StudyroomStateDTO;

public interface StudyroomStateService {

	List<StudyroomStateDTO> findAllStudyroomState() throws Exception;

	StudyroomStateDTO findStudyroomStateById(Long id) throws Exception;

	void insertStudyroomState(StudyroomStateDTO studyroomStateDTO) throws Exception;
}
