package com.jjplanet.ssaibrary.api.community.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjplanet.ssaibrary.api.community.domain.Community;

public interface CommunityRepository extends JpaRepository<Community, Long> {
	
	List<Community> findByStatus(char status);

}
