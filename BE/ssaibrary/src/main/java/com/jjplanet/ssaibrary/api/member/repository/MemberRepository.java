package com.jjplanet.ssaibrary.api.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjplanet.ssaibrary.api.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
	

	
    Optional<Member> findByNickname(String nickname);
    
    //로그인	
    Optional<Member> findByIdAndPassword(String id, String password);
	

}
