package com.jjplanet.ssaibrary.seat.controller;

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

import com.jjplanet.ssaibrary.seat.domain.Seat;
import com.jjplanet.ssaibrary.seat.dto.SeatDTO;
import com.jjplanet.ssaibrary.seat.service.SeatService;

@RestController
@RequestMapping("/seat")
public class SeatController {

	@Autowired
	private SeatService seatService;

	@PostMapping
	public void insertSeat(@RequestBody SeatDTO seatDTO) throws Exception {
		seatService.insertSeat(seatDTO);
	}

	@PutMapping("/{id}")
	public void updateSeat(@RequestBody SeatDTO seatDTO) throws Exception {
		seatService.updateSeat(seatDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteSeat(@PathVariable Long id) throws Exception {
		seatService.deleteSeat(id);
	}

	@GetMapping("/list")
	public List<SeatDTO> findAllSeat() throws Exception {
		return seatService.findAllSeat();
	}

	@GetMapping("/{id}")
	public SeatDTO findSeatById(@PathVariable Long id) throws Exception {
		System.out.println("id : " + id);
		return seatService.findSeatById(id);
	}
}
