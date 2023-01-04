package com.jjplanet.ssaibrary.seat.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.seat.domain.SeatReservation;
import com.jjplanet.ssaibrary.seat.dto.SeatReservationDTO;
import com.jjplanet.ssaibrary.seat.dto.SeatReservationExtensionDTO;
import com.jjplanet.ssaibrary.seat.repository.SeatReservationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeatReservationServiceImpl implements SeatReservationService {

	private final SeatReservationRepository seatReservationRepository;

	@Override
	public List<SeatReservationDTO> findAllSeatReservation() throws Exception {
		return seatReservationRepository.findAll().stream().map(SeatReservation::toDTOWithSeatReservation)
				.collect(Collectors.toList());

	}

	@Override
	public SeatReservationDTO findSeatReservationById(Long id) throws Exception {
		return seatReservationRepository.findById(id).orElseThrow(NotFoundException::new).toDTO();
	}

	@Override
	@Transactional
	public void reservationSeat(SeatReservationDTO seatReservationDTO) throws Exception {
		SeatReservation seatReservation = SeatReservation.builder().seatReservaionDTO(seatReservationDTO).build();
		seatReservationRepository.save(seatReservation);
	}

	@Override
	public boolean addTime(SeatReservationExtensionDTO seatReservationExtensionDTO) throws Exception {
		SeatReservation seatReservation = seatReservationRepository.findById(seatReservationExtensionDTO.getId())
				.orElseThrow(NotFoundException::new);

		// 시간 연장 최대 2번 가능
		int addCount = seatReservation.getAddCount();
		if (addCount < 2) {
			seatReservation.updateAddData(seatReservationExtensionDTO.getAddTime());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void deleteSeatReservation(Long id) throws Exception {
		SeatReservation seatReservation = seatReservationRepository.findById(id).orElseThrow(NotFoundException::new);
		seatReservation.updateStatus('X'); // X:예약취소
	}
}
