package com.jjplanet.ssaibrary.api.notice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjplanet.ssaibrary.api.notice.domain.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>{
	
	
	List<Notice> findByStatus(char status);

}
