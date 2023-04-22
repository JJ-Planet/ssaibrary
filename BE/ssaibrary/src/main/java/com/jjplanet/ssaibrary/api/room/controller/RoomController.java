package com.jjplanet.ssaibrary.api.room.controller;

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

import com.jjplanet.ssaibrary.api.room.service.RoomService;
import com.jjplanet.ssaibrary.api.room.dto.RoomDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/room")
@RequiredArgsConstructor
public class RoomController {

	private static final String SUCCESS = "success";

	private final RoomService roomService;

	@GetMapping
	public ResponseEntity<List<RoomDTO>> findAllRoom() throws Exception {
		return new ResponseEntity<List<RoomDTO>>(roomService.findAllRoom(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<RoomDTO> findRoomById(@PathVariable Long id) throws Exception {
		return new ResponseEntity<RoomDTO>(roomService.findRoomById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> insertRoom(@RequestBody RoomDTO roomDTO) throws Exception {
		roomService.insertRoom(roomDTO);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updateRoom(@RequestBody RoomDTO roomDTO) throws Exception {
		roomService.updateRoom(roomDTO);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteRoom(@PathVariable Long id) throws Exception {
		roomService.deleteRoom(id);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}
}
