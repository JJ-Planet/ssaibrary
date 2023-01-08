package com.jjplanet.ssaibrary.member.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.jjplanet.ssaibrary.member.domain.Member;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberCustomRepositoryImpl implements MemberCustomRepository{
	
	private final EntityManager em;
	
	//외래키 참조
//	@Override
//	public Member findByNickname(String nickname) {
//        return em.createQuery("select c from Member c where c.nickname=:nickname", Member.class)
//                .setParameter("nickname", nickname)
//                .getSingleResult();
//	}
	
	//로그인
//	@Override
//	public Optional<Member> loginMember(String id, String password) {
//	return Optional.ofNullable(em.createQuery("select m from Member m where m.id=:id and m.password=:password", Member.class)
//			.setParameter("id", id)
//			.setParameter("password", password)
//			.getSingleResult());
//	}

}
