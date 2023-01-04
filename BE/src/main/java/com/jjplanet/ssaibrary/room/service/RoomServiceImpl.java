package com.jjplanet.ssaibrary.room.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.room.domain.Room;
import com.jjplanet.ssaibrary.room.dto.RoomDTO;
import com.jjplanet.ssaibrary.room.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

	private final RoomRepository roomRepository;

	@Override
	public List<RoomDTO> findAllRoom() throws Exception {
		return roomRepository.findAll().stream().map(Room::toDTOWithRoom).collect(Collectors.toList());
	}

	@Override
	public RoomDTO findRoomById(Long id) throws Exception {
		return roomRepository.findById(id).orElseThrow(NotFoundException::new).toDTO();
	}

	@Override
	@Transactional
	public void insertRoom(RoomDTO roomDTO) throws Exception {
		Room room = Room.builder().roomDTO(roomDTO).build();
		roomRepository.save(room);
	}

	@Override
	public void updateRoom(RoomDTO roomDTO) throws Exception {
		Room room = roomRepository.findById(roomDTO.getId()).orElseThrow(NotFoundException::new);
		room.updateRoom(roomDTO);
	}

	@Override
	public void deleteRoom(Long id) throws Exception {
		roomRepository.deleteById(id);
	}
}
