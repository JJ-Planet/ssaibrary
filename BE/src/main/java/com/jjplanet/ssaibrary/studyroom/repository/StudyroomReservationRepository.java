package com.jjplanet.ssaibrary.studyroom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jjplanet.ssaibrary.studyroom.domain.StudyroomReservation;

public interface StudyroomReservationRepository extends JpaRepository<StudyroomReservation, Long> {

	@Query(value = "select * from studyroom_reservation where id = :id", nativeQuery = true)
	public Optional<StudyroomReservation> findOneById(@Param("id") Long id);
}
