package com.jjplanet.ssaibrary.room.service;

import java.util.List;

import com.jjplanet.ssaibrary.room.dto.RoomDTO;

public interface RoomService {

	List<RoomDTO> findAllRoom() throws Exception;
	
	RoomDTO findRoomById(Long id) throws Exception;

	void insertRoom(RoomDTO roomDTO) throws Exception;

	void updateRoom(RoomDTO roomDTO) throws Exception;

	void deleteRoom(Long id) throws Exception;
}
