package com.jjplanet.ssaibrary.studyroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.jjplanet.ssaibrary.studyroom.dto.StudyroomDTO;
import com.jjplanet.ssaibrary.studyroom.service.StudyroomService;

@RestController
@RequestMapping("/studyroom")
public class StudyroomController {

	private static final String SUCCESS = "success";

	@Autowired
	private StudyroomService studyroomService;

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

	@PutMapping("{id}")
	public ResponseEntity<?> updateStudyroom(@RequestBody StudyroomDTO studyroomDTO) throws Exception {
		studyroomService.updateStudyroom(studyroomDTO);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteStudyroom(@PathVariable Long id) throws Exception {
		studyroomService.deleteStudyroom(id);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}
}
