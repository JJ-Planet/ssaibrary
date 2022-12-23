package com.jjplanet.ssaibrary.studyroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jjplanet.ssaibrary.studyroom.domain.Studyroom;

@Repository
public interface StudyroomRepository extends JpaRepository<Studyroom, Long> {

	@Query(value = "select * from studyroom where id = :id", nativeQuery = true)
	public Studyroom findOndById(@Param("id") Long id);
}
