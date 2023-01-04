package com.jjplanet.ssaibrary.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jjplanet.ssaibrary.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
	

	
    Optional<Member> findByNickname(String nickname);
	
	

}
