package com.jjplanet.ssaibrary.studyroom.service;

import java.util.List;

import com.jjplanet.ssaibrary.studyroom.domain.Studyroom;
import com.jjplanet.ssaibrary.studyroom.dto.StudyroomDTO;

public interface StudyroomService {

	void insertStudyroom(Studyroom studyroom) throws Exception;

	void updateStudyroom(Studyroom studyroom) throws Exception;

	List<StudyroomDTO> findAllStudyroom() throws Exception;

	StudyroomDTO findStudyroomById(Long id) throws Exception;

	void deleteStudyroom(Long id) throws Exception;
}
