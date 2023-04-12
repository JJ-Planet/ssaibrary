package com.jjplanet.ssaibrary.api.comment.service;

import com.jjplanet.ssaibrary.api.comment.dto.InsertCommentDTO;
import com.jjplanet.ssaibrary.api.comment.dto.ReInsertCommentDTO;
import com.jjplanet.ssaibrary.common.exception.NotFoundException;


public interface CommentService {
	
	//댓글 작성
	void insertComment(InsertCommentDTO insertCommentDTO) throws NotFoundException;
	
	//대댓글 작성
	void reInsertComment(ReInsertCommentDTO reInsertCommentDTO) throws NotFoundException;

	//댓글 조회
//	Map<String, Object> findAllComment(Long communityId) throws NotFoundException;
	
	//댓글 삭제
	void deleteComment(Long id) throws NotFoundException;

}
