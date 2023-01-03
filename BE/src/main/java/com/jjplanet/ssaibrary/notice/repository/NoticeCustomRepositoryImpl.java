package com.jjplanet.ssaibrary.notice.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.jjplanet.ssaibrary.notice.domain.Notice;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class NoticeCustomRepositoryImpl implements NoticeCustomRepository{

	private final EntityManager em;

	// 전체 목록 불러오기
    @Override
    public List<Notice> findAllList() {
    	//status가 'V'인 게시글만 불러올 수 있음.
        return em.createQuery("select n from Notice n where n.status='V'",Notice.class)
                .getResultList();
    }


}