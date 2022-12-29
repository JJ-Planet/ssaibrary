package com.jjplanet.ssaibrary.room.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.room.domain.Room;
import com.jjplanet.ssaibrary.room.dto.RoomDTO;
import com.jjplanet.ssaibrary.room.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public List<RoomDTO> findAllRoom() throws Exception {
		List<Room> roomList = roomRepository.findAll();
		List<RoomDTO> roomDTOList = new LinkedList<>();
		for (Room r : roomList) {
			roomDTOList.add(
					new RoomDTO(r.getId(), r.getFloor(), r.getTotalSeat(), r.getReserveSeat(), r.getIsAvailable()));
		}
		return roomDTOList;
	}

	@Override
	public RoomDTO findRoomById(Long id) throws Exception {
		Room room = roomRepository.findById(id).orElseThrow(NotFoundException::new);
		RoomDTO roomDTO = new RoomDTO(room.getId(), room.getFloor(), room.getTotalSeat(), room.getReserveSeat(),
				room.getIsAvailable());
		return roomDTO;
	}

	@Override
	public void insertRoom(RoomDTO roomDTO) throws Exception {
		Room room = new Room(roomDTO.getId(), roomDTO.getFloor(), roomDTO.getTotalSeat(), roomDTO.getReserveSeat(), roomDTO.getIsAvailable());
		roomRepository.save(room);
	}

	@Override
	public void updateRoom(RoomDTO roomDTO) throws Exception {
		Room updateRoom = roomRepository.findById(roomDTO.getId()).orElseThrow(NotFoundException::new);

		updateRoom.setFloor(roomDTO.getFloor());
		updateRoom.setTotalSeat(roomDTO.getTotalSeat());
		updateRoom.setReserveSeat(roomDTO.getReserveSeat());
		updateRoom.setIsAvailable(roomDTO.getIsAvailable());
		roomRepository.save(updateRoom);
	}

	@Override
	public void deleteRoom(Long id) throws Exception {
		roomRepository.deleteById(id);
	}
}
