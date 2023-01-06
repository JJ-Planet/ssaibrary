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
@Transactional
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

	private final RoomRepository roomRepository;

	@Override
	public List<RoomDTO> findAllRoom() {
		return roomRepository.findAll().stream().map(Room::toDTO).collect(Collectors.toList());
	}

	@Override
	public RoomDTO findRoomById(Long id) {
		return roomRepository.findById(id).orElseThrow(NotFoundException::new).toDTO();
	}

	@Override
	public void insertRoom(RoomDTO roomDTO) {
		Room room = Room.builder().roomDTO(roomDTO).build();
		roomRepository.save(room);
	}

	@Override
	@Transactional
	public void updateRoom(RoomDTO roomDTO) {
		Room room = roomRepository.findById(roomDTO.getId()).orElseThrow(NotFoundException::new);
		room.updateRoom(roomDTO);
	}

	@Override
	public void deleteRoom(Long id) {
		roomRepository.deleteById(id);
	}
}
