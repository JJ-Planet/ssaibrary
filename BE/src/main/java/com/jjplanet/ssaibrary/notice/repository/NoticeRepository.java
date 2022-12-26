package com.jjplanet.ssaibrary.notice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjplanet.ssaibrary.notice.domain.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>{

}
