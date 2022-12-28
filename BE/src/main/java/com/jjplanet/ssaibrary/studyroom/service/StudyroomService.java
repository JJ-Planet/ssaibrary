package com.jjplanet.ssaibrary.studyroom.service;

import java.util.List;

import com.jjplanet.ssaibrary.studyroom.dto.StudyroomDTO;

public interface StudyroomService {

	List<StudyroomDTO> findAllStudyroom() throws Exception;

	StudyroomDTO findStudyroomById(Long id) throws Exception;
	
	void insertStudyroom(StudyroomDTO studyroomDTO) throws Exception;

	void updateStudyroom(StudyroomDTO studyroomDTO) throws Exception;

	void deleteStudyroom(Long id) throws Exception;
}
