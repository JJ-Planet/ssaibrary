package com.jjplanet.ssaibrary.notice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.notice.domain.Notice;
import com.jjplanet.ssaibrary.notice.dto.NoticeDTO;

public interface NoticeRepository extends JpaRepository<Notice, Long>{
	
	
	List<Notice> findByStatus(char status);

}
