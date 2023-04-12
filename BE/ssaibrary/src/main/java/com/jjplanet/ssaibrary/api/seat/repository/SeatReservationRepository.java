package com.jjplanet.ssaibrary.api.seat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jjplanet.ssaibrary.api.seat.domain.SeatReservation;

@Repository
public interface SeatReservationRepository extends JpaRepository<SeatReservation, Long> {

}
