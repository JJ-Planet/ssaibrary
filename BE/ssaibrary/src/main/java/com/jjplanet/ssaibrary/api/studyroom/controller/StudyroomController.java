package com.jjplanet.ssaibrary.api.studyroom.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjplanet.ssaibrary.api.studyroom.dto.StudyroomDTO;
import com.jjplanet.ssaibrary.api.studyroom.dto.StudyroomReservationDTO;
import com.jjplanet.ssaibrary.api.studyroom.dto.StudyroomStateDTO;
import com.jjplanet.ssaibrary.api.studyroom.service.StudyroomReservationService;
import com.jjplanet.ssaibrary.api.studyroom.service.StudyroomService;
import com.jjplanet.ssaibrary.api.studyroom.service.StudyroomStateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/studyroom")
@RequiredArgsConstructor
public class StudyroomController {

	private static final String SUCCESS = "success";

	private final StudyroomService studyroomService;

	private final StudyroomReservationService studyroomReservationService;

	private final StudyroomStateService studyroomStateService;

	// 스터디룸

	@GetMapping
	public ResponseEntity<List<StudyroomDTO>> findAllStudyroom() throws Exception {
		return new ResponseEntity<List<StudyroomDTO>>(studyroomService.findAllStudyroom(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<StudyroomDTO> findStudyroomById(@PathVariable Long id) throws Exception {
		return new ResponseEntity<StudyroomDTO>(studyroomService.findStudyroomById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> insertStudyroom(@RequestBody StudyroomDTO studyroomDTO) throws Exception {
		studyroomService.insertStudyroom(studyroomDTO);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updateStudyroom(@RequestBody StudyroomDTO studyroomDTO) throws Exception {
		studyroomService.updateStudyroom(studyroomDTO);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteStudyroom(@PathVariable Long id) throws Exception {
		studyroomService.deleteStudyroom(id);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	// 스터디룸 예약

	@GetMapping("reservation")
	public ResponseEntity<List<StudyroomReservationDTO>> findAllStudyroomReservation() throws Exception {
		return new ResponseEntity<List<StudyroomReservationDTO>>(
				studyroomReservationService.findAllStudyroomReservation(), HttpStatus.OK);
	}

	@GetMapping("reservation/{id}")
	public ResponseEntity<StudyroomReservationDTO> findStudyroomReservationById(@PathVariable Long id)
			throws Exception {
		return new ResponseEntity<StudyroomReservationDTO>(studyroomReservationService.findStudyroomReservationById(id),
				HttpStatus.OK);
	}

	@PostMapping("reservation")
	public ResponseEntity<?> reservationStudyroom(@RequestBody StudyroomReservationDTO studyroomReservationDTO)
			throws Exception {
		studyroomReservationService.reservationStudyroom(studyroomReservationDTO);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@DeleteMapping("reservation/{id}")
	public ResponseEntity<?> deleteStudyroomReservation(@PathVariable Long id) throws Exception {
		studyroomReservationService.deleteStudyroomReservation(id);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	// 스터디룸 상태

	@GetMapping("state")
	public ResponseEntity<List<StudyroomStateDTO>> findAllStudyroomState() throws Exception {
		return new ResponseEntity<List<StudyroomStateDTO>>(studyroomStateService.findAllStudyroomState(),
				HttpStatus.OK);
	}

	@GetMapping("state/{id}")
	public ResponseEntity<StudyroomStateDTO> findStudyroomStateById(@PathVariable Long id) throws Exception {
		return new ResponseEntity<StudyroomStateDTO>(studyroomStateService.findStudyroomStateById(id), HttpStatus.OK);
	}

	@PostMapping("state")
	public ResponseEntity<?> insertStudyroomState(@RequestBody StudyroomStateDTO studyroomStateDTO) throws Exception {
		studyroomStateService.insertStudyroomState(studyroomStateDTO);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}
}
