package com.jjplanet.ssaibrary.seat.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.seat.domain.Seat;
import com.jjplanet.ssaibrary.seat.domain.SeatReservation;
import com.jjplanet.ssaibrary.seat.dto.SeatReservationDTO;
import com.jjplanet.ssaibrary.seat.dto.SeatReservationExtensionDTO;
import com.jjplanet.ssaibrary.seat.repository.SeatRepository;
import com.jjplanet.ssaibrary.seat.repository.SeatReservationRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class SeatReservationServiceImpl implements SeatReservationService {

	private final SeatReservationRepository seatReservationRepository;

	private final MemberRepository memberRepository;

	private final SeatRepository seatRepository;

	@Override
	public List<SeatReservationDTO> findAllSeatReservation() {
		return seatReservationRepository.findAll().stream().map(SeatReservation::toDTO).collect(Collectors.toList());
	}

	@Override
	public SeatReservationDTO findSeatReservationById(Long id) {
		return seatReservationRepository.findById(id).orElseThrow(NotFoundException::new).toDTO();
	}

	@Override
	public void reservationSeat(SeatReservationDTO seatReservationDTO) {
		Member member = memberRepository.findById(seatReservationDTO.getMemberId()).orElseThrow(NotFoundException::new);
		Seat seat = seatRepository.findById(seatReservationDTO.getSeatId()).orElseThrow(NotFoundException::new);
		SeatReservation seatReservation = SeatReservation.builder().seatReservaionDTO(seatReservationDTO).member(member)
				.seat(seat).build();
		seatReservationRepository.save(seatReservation);
	}

	@Override
	public boolean addTime(SeatReservationExtensionDTO seatReservationExtensionDTO) {
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
	public void deleteSeatReservation(Long id) {
		SeatReservation seatReservation = seatReservationRepository.findById(id).orElseThrow(NotFoundException::new);
		seatReservation.updateStatus('X'); // X:예약취소
	}
}
