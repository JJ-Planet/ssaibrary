package com.jjplanet.ssaibrary.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jjplanet.ssaibrary.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
	

	
    Optional<Member> findByNickname(String nickname);
    
    //로그인
    @Query("select m from Member m where m.id=:id and m.password=:password")
    Optional<Member> loginMember(@Param("id") String id,@Param("password") String password);
	
	

}
