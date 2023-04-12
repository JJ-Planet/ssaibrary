package com.jjplanet.ssaibrary.api.faq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjplanet.ssaibrary.api.faq.domain.Faq;

public interface FaqRepository extends JpaRepository<Faq, Long> {


	
	List<Faq> findByStatus(char status);

}
