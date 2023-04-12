package com.jjplanet.ssaibrary.api.studyroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jjplanet.ssaibrary.api.studyroom.domain.Studyroom;

@Repository
public interface StudyroomRepository extends JpaRepository<Studyroom, Long> {

}
