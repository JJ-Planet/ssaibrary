package com.jjplanet.ssaibrary.member.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.jjplanet.ssaibrary.member.domain.Member;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberCustomRepositoryImpl implements MemberCustomRepository{
	
	private final EntityManager em;
	
    //상세조회
//	@Override
//	public Member findByNickname(String nickname) {
//        return em.createQuery("select c from Member c where c.nickname=:nickname", Member.class)
//                .setParameter("nickname", nickname)
//                .getSingleResult();
//	}

}
