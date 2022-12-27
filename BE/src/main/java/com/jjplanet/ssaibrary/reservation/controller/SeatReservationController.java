package com.jjplanet.ssaibrary.reservation.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjplanet.ssaibrary.reservation.domain.SeatReservation;
import com.jjplanet.ssaibrary.reservation.dto.SeatReservationDTO;
import com.jjplanet.ssaibrary.reservation.repository.SeatReservationRepository;
import com.jjplanet.ssaibrary.reservation.service.SeatReservationService;

@RestController
@RequestMapping("/seat-reservation")
public class SeatReservationController {

	@Autowired
	private SeatReservationService seatReservationService;

	@PostMapping
	public void reservationSeat(@RequestBody SeatReservationDTO seatReservationDTO) throws Exception {
		seatReservationService.reservationSeat(seatReservationDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteSeatReservation(@PathVariable Long id) throws Exception {
		seatReservationService.deleteSeatReservation(id);
	}

	public List<SeatReservationDTO> findAllSeatReservation() throws Exception {

		return null;
	}


	public SeatReservationDTO findSeatReservationById(Long id) throws Exception {
	
		return null;
	}
}
