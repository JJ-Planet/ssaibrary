package com.jjplanet.ssaibrary.notice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import javax.persistence.EntityManager;
import com.jjplanet.ssaibrary.notice.domain.Notice;

public interface NoticeCustomRepository{

	// 전체 목록 불러오기
    List<Notice> findAllList();

}