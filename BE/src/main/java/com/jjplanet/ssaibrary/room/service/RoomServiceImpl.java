package com.jjplanet.ssaibrary.room.service;

import java.util.LinkedList;
import java.util.List;

import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.room.domain.Room;
import com.jjplanet.ssaibrary.room.dto.RoomDTO;
import com.jjplanet.ssaibrary.room.repository.RoomRepository;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

	private final RoomRepository roomRepository;


	@Override
	public List<RoomDTO> findAllRoom() throws Exception {
		return roomRepository.findAll().stream().map(Room::toDtoWithRoom).collect(Collectors.toList());
	}

	@Override
	public RoomDTO findRoomById(Long id) throws Exception {
		return roomRepository.findById(id).orElseThrow(NotFoundException::new).toDto();
	}

	@Override
	public void insertRoom(RoomDTO roomDTO) throws Exception {
		Room room = Room.builder().roomDTO(roomDTO).build();
		// or
		Room room2 = new Room(roomDTO);

		roomRepository.save(room);
	}

	@Override
	@Transactional
	public void updateRoom(RoomDTO roomDTO) throws Exception {
		Room updateRoom = roomRepository.findById(roomDTO.getId()).orElseThrow(NotFoundException::new);

		updateRoom.updateRoom(roomDTO);
	}

	@Override
	public void deleteRoom(Long id) throws Exception {
		roomRepository.deleteById(id);
	}
}
