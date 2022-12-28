package com.jjplanet.ssaibrary.seat.service;

import java.util.List;

import com.jjplanet.ssaibrary.seat.dto.SeatDTO;

public interface SeatService {
	
	List<SeatDTO> findAllSeat() throws Exception;

	SeatDTO findSeatById(Long id) throws Exception;
	
	void insertSeat(SeatDTO seatDTO) throws Exception;

	void updateSeat(SeatDTO seatDTO) throws Exception;

	void deleteSeat(Long id) throws Exception;
}
