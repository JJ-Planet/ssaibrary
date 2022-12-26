package com.jjplanet.ssaibrary.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jjplanet.ssaibrary.room.domain.Room;

public interface StudyroomReservationRepository extends JpaRepository<Room, Long> {

	@Query(value = "select * from studyroom_reservation where id = :id", nativeQuery = true)
	public Room findOneById(@Param("id") Long id);
}
