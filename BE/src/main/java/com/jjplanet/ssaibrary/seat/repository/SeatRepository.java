package com.jjplanet.ssaibrary.seat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jjplanet.ssaibrary.seat.domain.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

}
