package com.jjplanet.ssaibrary.notice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import javax.persistence.EntityManager;
import com.jjplanet.ssaibrary.notice.domain.Notice;

public interface NoticeCustomRepository{
	
	// ��ü ��� �ҷ�����
    List<Notice> getAllList();
    
    //����ȸ
    Notice getOneById(Long id);

}
