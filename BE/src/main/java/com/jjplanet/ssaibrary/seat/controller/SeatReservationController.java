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

import com.jjplanet.ssaibrary.seat.dto.SeatReservationDTO;
import com.jjplanet.ssaibrary.seat.dto.SeatReservationExtensionDTO;
import com.jjplanet.ssaibrary.seat.service.SeatReservationService;

@RestController
@RequestMapping("/seat-reservation")
public class SeatReservationController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private SeatReservationService seatReservationService;

	@GetMapping
	public ResponseEntity<List<SeatReservationDTO>> findAllSeatReservation() throws Exception {
		return new ResponseEntity<List<SeatReservationDTO>>(seatReservationService.findAllSeatReservation(),
				HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<SeatReservationDTO> findSeatReservationById(@PathVariable Long id) throws Exception {
		return new ResponseEntity<SeatReservationDTO>(seatReservationService.findSeatReservationById(id),
				HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> reservationSeat(@RequestBody SeatReservationDTO seatReservationDTO) throws Exception {
		seatReservationService.reservationSeat(seatReservationDTO);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> addTime(@RequestBody SeatReservationExtensionDTO seatReservationExtensionDTO)
			throws Exception {
		if (seatReservationService.addTime(seatReservationExtensionDTO)) {
			// 연장 완료
			return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
		} else {
			// 연장 불가능
			return new ResponseEntity<>(FAIL, HttpStatus.OK);
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteSeatReservation(@PathVariable Long id) throws Exception {
		seatReservationService.deleteSeatReservation(id);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}
}
