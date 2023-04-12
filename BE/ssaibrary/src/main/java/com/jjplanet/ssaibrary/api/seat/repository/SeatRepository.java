package com.jjplanet.ssaibrary.api.seat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jjplanet.ssaibrary.api.seat.domain.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

}
