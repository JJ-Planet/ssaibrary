package com.jjplanet.ssaibrary.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jjplanet.ssaibrary.room.domain.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
