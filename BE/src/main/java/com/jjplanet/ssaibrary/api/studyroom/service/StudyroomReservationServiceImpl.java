package com.jjplanet.ssaibrary.api.studyroom.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jjplanet.ssaibrary.api.member.domain.Member;
import com.jjplanet.ssaibrary.api.member.repository.MemberRepository;
import com.jjplanet.ssaibrary.api.studyroom.repository.StudyroomRepository;
import com.jjplanet.ssaibrary.api.studyroom.repository.StudyroomReservationRepository;
import com.jjplanet.ssaibrary.common.exception.NotFoundException;
import com.jjplanet.ssaibrary.api.studyroom.domain.Studyroom;
import com.jjplanet.ssaibrary.api.studyroom.domain.StudyroomReservation;
import com.jjplanet.ssaibrary.api.studyroom.dto.StudyroomReservationDTO;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class StudyroomReservationServiceImpl implements StudyroomReservationService {

	private final StudyroomReservationRepository studyroomReservationRepository;

	private final MemberRepository memberRepository;

	private final StudyroomRepository studyroomRepository;

	@Override
	public List<StudyroomReservationDTO> findAllStudyroomReservation() {
		return studyroomReservationRepository.findAll().stream().map(StudyroomReservation::toDTO)
				.collect(Collectors.toList());
	}

	@Override
	public StudyroomReservationDTO findStudyroomReservationById(Long id) {
		return studyroomReservationRepository.findById(id).orElseThrow(NotFoundException::new).toDTO();
	}

	@Override
	public void reservationStudyroom(StudyroomReservationDTO studyroomReservationDTO) {
		Member member = memberRepository.findById(studyroomReservationDTO.getMemberId()).orElseThrow(NotFoundException::new);
		Studyroom studyroom = studyroomRepository.findById(studyroomReservationDTO.getStudyroomId()).orElseThrow(NotFoundException::new); 
		StudyroomReservation studyroomReservation = StudyroomReservation.builder()
				.studyroomReservationDTO(studyroomReservationDTO).member(member).studyroom(studyroom).build();
		studyroomReservationRepository.save(studyroomReservation);
	}

	@Override
	public void deleteStudyroomReservation(Long id) {
		StudyroomReservation studyroomReservation = studyroomReservationRepository.findById(id)
				.orElseThrow(NotFoundException::new);
		studyroomReservation.updateStatus('X'); // X:예약취소
	}
}
