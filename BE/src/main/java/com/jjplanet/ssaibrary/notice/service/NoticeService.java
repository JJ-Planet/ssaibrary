package com.jjplanet.ssaibrary.notice.service;

import java.util.List;

import com.jjplanet.ssaibrary.notice.domain.Notice;
import com.jjplanet.ssaibrary.notice.dto.NoticeRequestDTO;
import com.jjplanet.ssaibrary.notice.dto.NoticeResponseDTO;

public interface NoticeService {
	
	//���ۼ�
	void insert(NoticeRequestDTO n); 
	
	//��ü�����ȸ
	List<NoticeResponseDTO> getAllList(); 
	
	//����ȸ
	NoticeResponseDTO getOneById(Long id);
	
	//�ۼ���
	void update(Long id, NoticeRequestDTO n);
	
	//�ۻ���
	void delete(Long id);

}
