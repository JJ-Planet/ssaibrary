package com.jjplanet.ssaibrary.api.studyroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jjplanet.ssaibrary.api.studyroom.domain.StudyroomReservation;

@Repository
public interface StudyroomReservationRepository extends JpaRepository<StudyroomReservation, Long> {

}
