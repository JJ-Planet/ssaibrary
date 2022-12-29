package com.jjplanet.ssaibrary.inquiry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jjplanet.ssaibrary.inquiry.domain.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
	
	//전체목록조회
	@Query(value = "select * from Inquiry where status != 'D'", nativeQuery = true)
	List<Inquiry> findAllList();
	
	//상세조회
	@Query(value = "select * from Inquiry where id=:id", nativeQuery = true)
	Inquiry findOneById(@Param("id")Long id);

}
