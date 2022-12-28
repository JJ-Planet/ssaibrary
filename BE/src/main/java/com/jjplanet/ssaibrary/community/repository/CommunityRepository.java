package com.jjplanet.ssaibrary.community.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jjplanet.ssaibrary.community.domain.Community;
import com.jjplanet.ssaibrary.community.dto.FindOneCommunityByIdDTO;

public interface CommunityRepository extends JpaRepository<Community, Long> {

	// 전체 목록 불러오기
	@Query(value = "select * from Community where status='V'", nativeQuery = true)
	List<Community> findAllList();

	// 상세조회
	@Query(value = "select * from Community where id=:id", nativeQuery = true)
	Community findOneById(@Param("id") Long id);
}
