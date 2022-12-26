package com.jjplanet.ssaibrary.studyroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjplanet.ssaibrary.studyroom.domain.Studyroom;
import com.jjplanet.ssaibrary.studyroom.dto.StudyroomDTO;
import com.jjplanet.ssaibrary.studyroom.service.StudyroomService;

@RestController
@RequestMapping("/studyroom")
public class StudyroomController {

	@Autowired
	private StudyroomService studyroomService;
	
	@PostMapping
	public void insertStudyroom(@RequestBody Studyroom studyroom) throws Exception {
		studyroomService.insertStudyroom(studyroom);
	}
	
	@PutMapping("/{id}")
	public void updateStudyroom(@RequestBody Studyroom studyroom) throws Exception {
		studyroomService.updateStudyroom(studyroom);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudyroom(@PathVariable Long id) throws Exception {
		studyroomService.deleteStudyroom(id);
	}
	
	@GetMapping("/list")
	public List<StudyroomDTO> findAllStudyroom() throws Exception {
		return studyroomService.findAllStudyroom();
	}

	@GetMapping("/{id}")
	public StudyroomDTO findStudyroomById(@PathVariable Long id) throws Exception {
		System.out.println("id : " + id);
		return studyroomService.findStudyroomById(id);
	}
}
