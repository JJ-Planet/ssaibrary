package com.jjplanet.ssaibrary.faq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jjplanet.ssaibrary.faq.domain.Faq;

public interface FaqRepository extends JpaRepository<Faq, Long> {

	// 전체목록조회
	@Query(value = "select * from Faq where status='V'", nativeQuery = true)
	List<Faq> findAllList();

	@Query(value = "select * from Faq where id=:id", nativeQuery = true)
	Faq findOneById(@Param("id") Long id);

}
