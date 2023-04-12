package com.jjplanet.ssaibrary.api.inquiry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjplanet.ssaibrary.api.inquiry.domain.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
	

}
