package com.jjplanet.ssaibrary.room.service;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.room.domain.Room;
import com.jjplanet.ssaibrary.room.dto.RoomDTO;
import com.jjplanet.ssaibrary.room.repository.RoomJpaRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomJpaRepository roomRepository;


    @Override
    @Transactional(readOnly = true)
    public List<RoomDTO> findAllRoom() {
        return roomRepository.findAll().stream().map(Room::toDtoWithRoom)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public RoomDTO findRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(NotFoundException::new).toDto();
    }

    @Override
    @Transactional
    public void insertRoom(RoomDTO roomDTO) {
        Room room = Room.builder().roomDTO(roomDTO).build();
        // or
        Room room2 = new Room(roomDTO);

        roomRepository.save(room);
    }

    @Override
    @Transactional
    public void updateRoom(RoomDTO roomDTO) {
        Room updateRoom = roomRepository.findById(roomDTO.getId())
            .orElseThrow(NotFoundException::new);

        updateRoom.updateRoom(roomDTO);
    }

    @Override
    @Transactional
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
