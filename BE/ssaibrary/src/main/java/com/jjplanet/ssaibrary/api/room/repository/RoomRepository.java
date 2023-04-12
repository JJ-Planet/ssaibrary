package com.jjplanet.ssaibrary.api.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jjplanet.ssaibrary.api.room.domain.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
