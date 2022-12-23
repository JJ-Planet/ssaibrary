package com.jjplanet.ssaibrary.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jjplanet.ssaibrary.room.domain.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

	@Query(value = "select * from room where id = :id", nativeQuery = true)
	public Room findOndById(@Param("id") Long id);
}
