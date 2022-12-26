package com.jjplanet.ssaibrary.inquiry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjplanet.ssaibrary.inquiry.domain.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

}
