package com.jjplanet.ssaibrary.studyroom.service;

import java.util.List;

import com.jjplanet.ssaibrary.studyroom.dto.StudyroomDTO;

public interface StudyroomService {

	List<StudyroomDTO> findAllStudyroom();

	StudyroomDTO findStudyroomById(Long id);
	
	void insertStudyroom(StudyroomDTO studyroomDTO);

	void updateStudyroom(StudyroomDTO studyroomDTO);

	void deleteStudyroom(Long id);
}
