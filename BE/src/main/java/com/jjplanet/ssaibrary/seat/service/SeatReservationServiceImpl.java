package com.jjplanet.ssaibrary.seat.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.seat.domain.SeatReservation;
import com.jjplanet.ssaibrary.seat.dto.SeatReservationDTO;
import com.jjplanet.ssaibrary.seat.dto.SeatReservationExtensionDTO;
import com.jjplanet.ssaibrary.seat.repository.SeatReservationRepository;
import com.jjplanet.ssaibrary.seat.domain.Seat;
import com.jjplanet.ssaibrary.seat.repository.SeatRepository;

@Service
public class SeatReservationServiceImpl implements SeatReservationService {

	@Autowired
	private SeatReservationRepository seatReservationRepository;
	
	@Autowired
	private SeatRepository seatRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public List<SeatReservationDTO> findAllSeatReservation() throws Exception {
		List<SeatReservation> reservaionList = seatReservationRepository.findAll();
		List<SeatReservationDTO> reservationDTOList = new LinkedList<>();
		for (SeatReservation sr : reservaionList) {
			reservationDTOList.add(new SeatReservationDTO(sr.getId(), sr.getMember().getId(),
					sr.getMember().getNickname(), sr.getSeat().getId(), sr.getReservationDate(), sr.getStartDate(),
					sr.getTime(), sr.getCheckinDate(), sr.getCheckoutDate(), sr.getAddTime(), sr.getAddCount(),
					sr.getStatus()));
		}
		return reservationDTOList;
	}

	@Override
	public SeatReservationDTO findSeatReservationById(Long id) throws Exception {
		SeatReservation reservation = seatReservationRepository.findOneById(id).orElseThrow(NotFoundException::new);
		SeatReservationDTO reservationDTO = new SeatReservationDTO(reservation.getId(), reservation.getMember().getId(),
				reservation.getMember().getNickname(), reservation.getSeat().getId(), reservation.getReservationDate(),
				reservation.getStartDate(), reservation.getTime(), reservation.getCheckinDate(),
				reservation.getCheckoutDate(), reservation.getAddTime(), reservation.getAddCount(),
				reservation.getStatus());
		return reservationDTO;
	}

	@Override
	public void reservationSeat(SeatReservationDTO seatReservationDTO) throws Exception {
		Member member = memberRepository.findOneById(seatReservationDTO.getMemberId())
				.orElseThrow(NotFoundException::new);
		Seat seat = seatRepository.findOneById(seatReservationDTO.getSeatId()).orElseThrow(NotFoundException::new);
		SeatReservation seatReservation = new SeatReservation(seatReservationDTO.getId(), member, seat,
				seatReservationDTO.getReservationDate(), seatReservationDTO.getStartDate(),
				seatReservationDTO.getTime(), seatReservationDTO.getCheckinDate(), seatReservationDTO.getCheckoutDate(),
				seatReservationDTO.getAddTime(), seatReservationDTO.getAddCount(), seatReservationDTO.getStatus());
		seatReservationRepository.save(seatReservation);
	}

	@Override
	public boolean addTime(SeatReservationExtensionDTO seatReservationExtensionDTO) throws Exception {
		SeatReservation seatReservation = seatReservationRepository.findOneById(seatReservationExtensionDTO.getId())
				.orElseThrow(NotFoundException::new);
		
		// 시간 연장 최대 2번 가능
		int addCount = seatReservation.getAddCount();
		if (addCount < 2) {
			seatReservation.setAddTime(seatReservation.getAddTime() + seatReservationExtensionDTO.getAddTime());
			seatReservation.setAddCount(addCount + 1);
			seatReservationRepository.save(seatReservation);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void deleteSeatReservation(Long id) throws Exception {
		SeatReservation seatReservation = seatReservationRepository.findOneById(id).orElseThrow(NotFoundException::new);
		seatReservation.setStatus('X'); // X:예약취소
		seatReservationRepository.save(seatReservation);
	}
}
