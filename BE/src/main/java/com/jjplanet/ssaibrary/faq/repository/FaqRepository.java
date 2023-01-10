package com.jjplanet.ssaibrary.faq.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jjplanet.ssaibrary.faq.domain.Faq;

public interface FaqRepository extends JpaRepository<Faq, Long> {


	
	List<Faq> findByStatus(char status);

}
