package com.jjplanet.ssaibrary.studyroom.service;

import java.util.List;

import com.jjplanet.ssaibrary.studyroom.dto.StudyroomReservationDTO;

public interface StudyroomReservationService {

	List<StudyroomReservationDTO> findAllStudyroomReservation() throws Exception;

	StudyroomReservationDTO findStudyroomReservationById(Long id) throws Exception;

	void reservationStudyroom(StudyroomReservationDTO studyroomReservationDTO) throws Exception;

	void deleteStudyroomReservation(Long id) throws Exception;
}
