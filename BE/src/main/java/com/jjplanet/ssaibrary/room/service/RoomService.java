package com.jjplanet.ssaibrary.room.service;

import java.util.List;

import com.jjplanet.ssaibrary.room.dto.RoomDTO;

public interface RoomService {

	List<RoomDTO> findAllRoom();

	RoomDTO findRoomById(Long id);

	void insertRoom(RoomDTO roomDTO);

	void updateRoom(RoomDTO roomDTO);

	void deleteRoom(Long id);
}
