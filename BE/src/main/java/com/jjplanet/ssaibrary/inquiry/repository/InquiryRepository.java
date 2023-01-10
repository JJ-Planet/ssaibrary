package com.jjplanet.ssaibrary.inquiry.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jjplanet.ssaibrary.inquiry.domain.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
	

}
