package com.jjplanet.ssaibrary.seat.service;

import java.util.List;

import com.jjplanet.ssaibrary.seat.dto.SeatReservationDTO;
import com.jjplanet.ssaibrary.seat.dto.SeatReservationExtensionDTO;

public interface SeatReservationService {

	List<SeatReservationDTO> findAllSeatReservation() throws Exception;

	SeatReservationDTO findSeatReservationById(Long id) throws Exception;

	void reservationSeat(SeatReservationDTO seatReservationDTO) throws Exception;

	boolean addTime(SeatReservationExtensionDTO seatReservationExtensionDTO) throws Exception;
	
	void deleteSeatReservation(Long id) throws Exception;
}
