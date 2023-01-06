package com.jjplanet.ssaibrary.seat.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.room.domain.Room;
import com.jjplanet.ssaibrary.room.repository.RoomRepository;
import com.jjplanet.ssaibrary.seat.domain.Seat;
import com.jjplanet.ssaibrary.seat.dto.SeatDTO;
import com.jjplanet.ssaibrary.seat.repository.SeatRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

	private final SeatRepository seatRepository;

	private final RoomRepository roomRepository;

	@Override
	public List<SeatDTO> findAllSeat() {
		return seatRepository.findAll().stream().map(Seat::toDTO).collect(Collectors.toList());
	}

	@Override
	public SeatDTO findSeatById(Long id) {
		return seatRepository.findById(id).orElseThrow(NotFoundException::new).toDTO();
	}

	@Override
	public void insertSeat(SeatDTO seatDTO) {
		Room room = roomRepository.findById(seatDTO.getRoomId()).orElseThrow(NotFoundException::new);
		Seat seat = Seat.builder().seatDTO(seatDTO).room(room).build();
		seatRepository.save(seat);
	}

	@Override
	public void updateSeat(SeatDTO seatDTO) {
		Seat seat = seatRepository.findById(seatDTO.getId()).orElseThrow(NotFoundException::new);
		Room room = roomRepository.findById(seatDTO.getRoomId()).orElseThrow(NotFoundException::new);
		seat.updateSeat(seatDTO, room);
	}

	@Override
	public void deleteSeat(Long id) {
		seatRepository.deleteById(id);
	}
}
