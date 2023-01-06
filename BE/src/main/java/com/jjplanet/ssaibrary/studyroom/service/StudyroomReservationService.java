package com.jjplanet.ssaibrary.studyroom.service;

import java.util.List;

import com.jjplanet.ssaibrary.studyroom.dto.StudyroomReservationDTO;

public interface StudyroomReservationService {

	List<StudyroomReservationDTO> findAllStudyroomReservation();

	StudyroomReservationDTO findStudyroomReservationById(Long id);

	void reservationStudyroom(StudyroomReservationDTO studyroomReservationDTO);

	void deleteStudyroomReservation(Long id);
}
