package com.jjplanet.ssaibrary.community.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jjplanet.ssaibrary.community.domain.Community;
import com.jjplanet.ssaibrary.community.dto.FindOneCommunityByIdDTO;

public interface CommunityRepository extends JpaRepository<Community, Long> {
	
	List<Community> findByStatus(char status);

}
