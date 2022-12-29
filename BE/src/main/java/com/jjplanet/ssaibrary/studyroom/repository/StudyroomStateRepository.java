package com.jjplanet.ssaibrary.studyroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jjplanet.ssaibrary.studyroom.domain.StudyroomState;

@Repository
public interface StudyroomStateRepository extends JpaRepository<StudyroomState, Long> {

}