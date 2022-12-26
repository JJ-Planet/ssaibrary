package com.jjplanet.ssaibrary.notice.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.jjplanet.ssaibrary.notice.domain.Notice;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class NoticeCustomRepositoryImpl implements NoticeCustomRepository{

	private final EntityManager em;
	
	// ��ü ��� �ҷ�����
    @Override
    public List<Notice> getAllList() {
    	//status�� 'V'�� �Խñ۸� �ҷ��� �� ����.
        return em.createQuery("select n from Notice n where n.status='V'",Notice.class)
                .getResultList();
    }

    //����ȸ
	@Override
	public Notice getOneById(Long id) {
        return em.createQuery("select n from Notice n where n.id=:id", Notice.class)
                .setParameter("id", id)
                .getSingleResult();
	}
}
