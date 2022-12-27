package com.jjplanet.ssaibrary.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jjplanet.ssaibrary.reservation.domain.SeatReservation;

@Repository
public interface SeatReservationRepository extends JpaRepository<SeatReservation, Long> {

	@Query(value = "select * from seat_reservation where id = :id", nativeQuery = true)
	public SeatReservation findOneById(@Param("id") Long id);
}
