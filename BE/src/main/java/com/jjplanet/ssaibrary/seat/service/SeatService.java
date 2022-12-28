package com.jjplanet.ssaibrary.seat.service;

import java.util.List;

import com.jjplanet.ssaibrary.seat.dto.SeatDTO;

public interface SeatService {
	
	boolean insertSeat(SeatDTO seatDTO) throws Exception;

	boolean updateSeat(SeatDTO seatDTO) throws Exception;

	List<SeatDTO> findAllSeat() throws Exception;

	SeatDTO findSeatById(Long id) throws Exception;

	boolean deleteSeat(Long id) throws Exception;
}
