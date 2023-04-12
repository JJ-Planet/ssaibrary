package com.jjplanet.ssaibrary.api.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjplanet.ssaibrary.api.comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	

}
