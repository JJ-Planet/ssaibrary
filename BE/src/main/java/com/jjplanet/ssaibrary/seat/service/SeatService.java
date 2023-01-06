package com.jjplanet.ssaibrary.seat.service;

import java.util.List;

import com.jjplanet.ssaibrary.seat.dto.SeatDTO;

public interface SeatService {
	
	List<SeatDTO> findAllSeat();

	SeatDTO findSeatById(Long id);
	
	void insertSeat(SeatDTO seatDTO);

	void updateSeat(SeatDTO seatDTO);

	void deleteSeat(Long id);
}
