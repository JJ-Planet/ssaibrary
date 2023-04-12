package com.jjplanet.ssaibrary.api.seat.service;

import java.util.List;

import com.jjplanet.ssaibrary.api.seat.dto.SeatDTO;

public interface SeatService {
	
	List<SeatDTO> findAllSeat();

	SeatDTO findSeatById(Long id);
	
	void insertSeat(SeatDTO seatDTO);

	void updateSeat(SeatDTO seatDTO);

	void deleteSeat(Long id);
}
