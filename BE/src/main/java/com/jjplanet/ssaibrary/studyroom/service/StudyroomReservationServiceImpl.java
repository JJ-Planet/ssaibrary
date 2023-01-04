package com.jjplanet.ssaibrary.studyroom.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.studyroom.domain.Studyroom;
import com.jjplanet.ssaibrary.studyroom.domain.StudyroomReservation;
import com.jjplanet.ssaibrary.studyroom.dto.StudyroomReservationDTO;
import com.jjplanet.ssaibrary.studyroom.repository.StudyroomRepository;
import com.jjplanet.ssaibrary.studyroom.repository.StudyroomReservationRepository;

@Service
public class StudyroomReservationServiceImpl implements StudyroomReservationService {

	@Autowired
	private StudyroomReservationRepository studyroomReservationRepository;

	@Autowired
	private StudyroomRepository studyroomRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public List<StudyroomReservationDTO> findAllStudyroomReservation() throws Exception {
		List<StudyroomReservation> reservaionList = studyroomReservationRepository.findAll();
		List<StudyroomReservationDTO> reservationDTOList = new LinkedList<>();
		for (StudyroomReservation sr : reservaionList) {
			reservationDTOList.add(new StudyroomReservationDTO(sr.getId(), sr.getMember().getId(),
					sr.getMember().getNickname(), sr.getStudyroom().getId(), sr.getPurpose(), sr.getUserCount(),
					sr.getReservationDate(), sr.getStartDate(), sr.getTime(), sr.getCheckinDate(), sr.getCheckoutDate(),
					sr.getStatus()));
		}
		return reservationDTOList;
	}

	@Override
	public StudyroomReservationDTO findStudyroomReservationById(Long id) throws Exception {
		StudyroomReservation reservation = studyroomReservationRepository.findById(id)
				.orElseThrow(NotFoundException::new);
		StudyroomReservationDTO reservationDTO = new StudyroomReservationDTO(reservation.getId(),
				reservation.getMember().getId(), reservation.getMember().getNickname(),
				reservation.getStudyroom().getId(), reservation.getPurpose(), reservation.getUserCount(),
				reservation.getReservationDate(), reservation.getStartDate(), reservation.getTime(),
				reservation.getCheckinDate(), reservation.getCheckoutDate(), reservation.getStatus());
		return reservationDTO;
	}

	@Override
	public void reservationStudyroom(StudyroomReservationDTO studyroomReservationDTO) throws Exception {
		Member member = memberRepository.findById(studyroomReservationDTO.getMemberId())
				.orElseThrow(NotFoundException::new);
		Studyroom studyroom = studyroomRepository.findById(studyroomReservationDTO.getStudyroomId())
				.orElseThrow(NotFoundException::new);
		StudyroomReservation studyroomReservation = new StudyroomReservation(studyroomReservationDTO.getId(), member,
				studyroom, studyroomReservationDTO.getPurpose(), studyroomReservationDTO.getUserCount(),
				studyroomReservationDTO.getReservationDate(), studyroomReservationDTO.getStartDate(),
				studyroomReservationDTO.getTime(), studyroomReservationDTO.getCheckinDate(),
				studyroomReservationDTO.getCheckoutDate(), studyroomReservationDTO.getStatus());
		studyroomReservationRepository.save(studyroomReservation);
	}

	@Override
	public void deleteStudyroomReservation(Long id) throws Exception {
		StudyroomReservation studyroomReservation = studyroomReservationRepository.findById(id)
				.orElseThrow(NotFoundException::new);
		studyroomReservation.setStatus('X'); // X:예약취소
		studyroomReservationRepository.save(studyroomReservation);
	}
}
