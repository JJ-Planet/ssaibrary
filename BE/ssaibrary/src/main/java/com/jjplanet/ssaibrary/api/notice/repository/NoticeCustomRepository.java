package com.jjplanet.ssaibrary.api.notice.repository;

import java.util.List;

import com.jjplanet.ssaibrary.api.notice.domain.Notice;

public interface NoticeCustomRepository{

	// 전체 목록 불러오기
    List<Notice> findAllList();

}