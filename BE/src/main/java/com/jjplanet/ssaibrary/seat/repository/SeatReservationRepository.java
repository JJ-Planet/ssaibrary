package com.jjplanet.ssaibrary.seat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jjplanet.ssaibrary.seat.domain.SeatReservation;

@Repository
public interface SeatReservationRepository extends JpaRepository<SeatReservation, Long> {

	@Query(value = "select * from seat_reservation where id = :id", nativeQuery = true)
	public Optional<SeatReservation> findOneById(@Param("id") Long id);
}
