package com.jjplanet.ssaibrary.seat.service;

import java.util.List;

import com.jjplanet.ssaibrary.seat.dto.SeatReservationDTO;
import com.jjplanet.ssaibrary.seat.dto.SeatReservationExtensionDTO;

public interface SeatReservationService {

	List<SeatReservationDTO> findAllSeatReservation();

	SeatReservationDTO findSeatReservationById(Long id);

	void reservationSeat(SeatReservationDTO seatReservationDTO);

	boolean addTime(SeatReservationExtensionDTO seatReservationExtensionDTO);
	
	void deleteSeatReservation(Long id);
}
