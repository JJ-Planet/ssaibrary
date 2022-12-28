package com.jjplanet.ssaibrary.room.controller;

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

import com.jjplanet.ssaibrary.room.dto.RoomDTO;
import com.jjplanet.ssaibrary.room.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@PostMapping
	public void insertRoom(@RequestBody RoomDTO roomDTO) throws Exception {
		roomService.insertRoom(roomDTO);
	}

	@PutMapping("/{id}")
	public void updateRoom(@RequestBody RoomDTO roomDTO) throws Exception {
		roomService.updateRoom(roomDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteRoom(@PathVariable Long id) throws Exception {
		roomService.deleteRoom(id);
	}

	@GetMapping("/list")
	public List<RoomDTO> findAllRoom() throws Exception {
		return roomService.findAllRoom();
	}

	@GetMapping("/{id}")
	public RoomDTO findRoomById(@PathVariable Long id) throws Exception {
		return roomService.findRoomById(id);
	}
}
