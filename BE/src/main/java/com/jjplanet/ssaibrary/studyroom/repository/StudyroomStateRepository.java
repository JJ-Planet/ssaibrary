package com.jjplanet.ssaibrary.studyroom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jjplanet.ssaibrary.studyroom.domain.StudyroomState;

public interface StudyroomStateRepository extends JpaRepository<StudyroomState, Long> {

	@Query(value = "select * from studyroom_state where id = :id", nativeQuery = true)
	public Optional<StudyroomState> findOneById(@Param("id") Long id);
}