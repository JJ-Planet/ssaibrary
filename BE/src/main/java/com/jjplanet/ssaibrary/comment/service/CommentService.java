package com.jjplanet.ssaibrary.comment.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.jjplanet.ssaibrary.comment.dto.InsertCommentDTO;
import com.jjplanet.ssaibrary.comment.dto.ReInsertCommentDTO;
import com.jjplanet.ssaibrary.exception.NotFoundException;


public interface CommentService {
	
	//댓글 작성
	void insertComment(InsertCommentDTO c) throws NotFoundException;
	
	//대댓글 작성
	void reInsertComment(ReInsertCommentDTO c) throws NotFoundException;

	//댓글 조회
//	Map<String, Object> findAllComment(Long communityId) throws NotFoundException;
	
	//댓글 삭제
	void deleteComment(Long id) throws NotFoundException;

}
