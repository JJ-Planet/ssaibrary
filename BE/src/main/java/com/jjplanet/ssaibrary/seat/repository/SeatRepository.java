package com.jjplanet.ssaibrary.seat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jjplanet.ssaibrary.seat.domain.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

	@Query(value = "select * from seat where id = :id", nativeQuery = true)
	public Seat findOneById(@Param("id") Long id);
}
