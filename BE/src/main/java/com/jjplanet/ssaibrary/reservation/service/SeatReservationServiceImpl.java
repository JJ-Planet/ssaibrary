package com.jjplanet.ssaibrary.reservation.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.reservation.domain.SeatReservation;
import com.jjplanet.ssaibrary.reservation.dto.SeatReservationDTO;
import com.jjplanet.ssaibrary.reservation.repository.SeatReservationRepository;
import com.jjplanet.ssaibrary.seat.domain.Seat;
import com.jjplanet.ssaibrary.seat.repository.SeatRepository;

@Service
public class SeatReservationServiceImpl implements SeatReservationService {

	@Autowired
	private SeatReservationRepository seatReservationRepository;


	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Override
	public void reservationSeat(SeatReservationDTO seatReservationDTO) throws Exception {
		Member member = memberRepository.findOneById(seatReservationDTO.getMember_id()).orElseThrow(NotFoundException::new);
		Seat seat = seatRepository.findOneById(seatReservationDTO.getSeat_id());
//		SeatReservation seatReservation = new SeatReservation(seatReservationDTO.getId(), member, seat, seatReservationDTO.getReservationDate(), seatReservationDTO.getStartDate(), seatReservationDTO.getTime(), seatReservationDTO.getCheckinDate(), seatReservationDTO.getCheckoutDate(), seatReservationDTO.getAddTime(), seatReservationDTO.getAddCount(), seatReservationDTO.getStatus()));
//		seatReservationRepository.save(seatReservation);
	}

	@Override
	public List<SeatReservationDTO> findAllSeatReservation() throws Exception {
		List<SeatReservation> reservaionList = seatReservationRepository.findAll();
		List<SeatReservationDTO> reservationDTOList = new LinkedList<>();
		for(SeatReservation sr : reservaionList) {
			reservationDTOList.add(
					new SeatReservationDTO(sr.getId(), sr.getMember().getId(), sr.getMember().getNickname(), sr.getSeat().getId(), sr.getReservationDate(), sr.getStartDate(), sr.getTime(), sr.getCheckinDate(), sr.getCheckoutDate(), sr.getAddTime(), sr.getAddCount(), sr.getStatus()));
		}
		return reservationDTOList;
	}

	@Override
	public SeatReservationDTO findSeatReservationById(Long id) throws Exception {
		SeatReservation reservaion = seatReservationRepository.findOneById(id);
		SeatReservationDTO reservationDTO = new SeatReservationDTO(reservaion.getId(), reservaion.getMember().getId(), reservaion.getMember().getNickname(), reservaion.getSeat().getId(), reservaion.getReservationDate(), reservaion.getStartDate(), reservaion.getTime(), reservaion.getCheckinDate(), reservaion.getCheckoutDate(), reservaion.getAddTime(), reservaion.getAddCount(), reservaion.getStatus());
		return reservationDTO;
	}

	@Override
	public void deleteSeatReservation(Long id) throws Exception {
		SeatReservation seatReservation = seatReservationRepository.findOneById(id);

		// if seatReservation == null

		seatReservation.setStatus('X'); // X:예약취소
		seatReservationRepository.save(seatReservation);
	}
}
