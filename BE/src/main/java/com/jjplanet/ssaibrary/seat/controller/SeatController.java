package com.jjplanet.ssaibrary.seat.controller;

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

import com.jjplanet.ssaibrary.seat.dto.SeatDTO;
import com.jjplanet.ssaibrary.seat.service.SeatService;

@RestController
@RequestMapping("/seat")
public class SeatController {

	private static final String SUCCESS = "success";

	@Autowired
	private SeatService seatService;

	@GetMapping
	public ResponseEntity<List<SeatDTO>> findAllSeat() throws Exception {
		return new ResponseEntity<List<SeatDTO>>(seatService.findAllSeat(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<SeatDTO> findSeatById(@PathVariable Long id) throws Exception {
		return new ResponseEntity<SeatDTO>(seatService.findSeatById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> insertSeat(@RequestBody SeatDTO seatDTO) throws Exception {
		seatService.insertSeat(seatDTO);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateSeat(@RequestBody SeatDTO seatDTO) throws Exception {
		seatService.updateSeat(seatDTO);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteSeat(@PathVariable Long id) throws Exception {
		seatService.deleteSeat(id);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}
}
