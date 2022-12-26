package com.jjplanet.ssaibrary.room.service;

import java.util.List;

import com.jjplanet.ssaibrary.room.domain.Room;
import com.jjplanet.ssaibrary.room.dto.RoomDTO;

public interface RoomService {

	void insertRoom(Room room) throws Exception;

	void updateRoom(Room room) throws Exception;

	List<RoomDTO> findAllRoom() throws Exception;

	RoomDTO findRoomById(Long id) throws Exception;

	void deleteRoom(Long id) throws Exception;
}
