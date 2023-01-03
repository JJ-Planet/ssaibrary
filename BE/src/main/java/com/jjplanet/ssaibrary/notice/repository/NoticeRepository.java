package com.jjplanet.ssaibrary.notice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.jjplanet.ssaibrary.notice.domain.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>{
	
	//상세조회
    Optional<Notice> findOneById(@Param("id") Long id);

}
