package com.jjplanet.ssaibrary.api.room.service;

import java.util.List;

import com.jjplanet.ssaibrary.api.room.dto.RoomDTO;

public interface RoomService {

	List<RoomDTO> findAllRoom();

	RoomDTO findRoomById(Long id);

	void insertRoom(RoomDTO roomDTO);

	void updateRoom(RoomDTO roomDTO);

	void deleteRoom(Long id);
}
