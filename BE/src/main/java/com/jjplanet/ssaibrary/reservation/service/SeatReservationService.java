package com.jjplanet.ssaibrary.reservation.service;

import java.util.List;

import com.jjplanet.ssaibrary.reservation.dto.SeatReservationDTO;

public interface SeatReservationService {
	
	void reservationSeat(SeatReservationDTO seatReservationDTO) throws Exception;
	
	List<SeatReservationDTO> findAllSeatReservation() throws Exception;
	
	SeatReservationDTO findSeatReservationById(Long id) throws Exception;
	
	void deleteSeatReservation(Long id) throws Exception;
}
