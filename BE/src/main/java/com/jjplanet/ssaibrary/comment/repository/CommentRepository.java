package com.jjplanet.ssaibrary.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjplanet.ssaibrary.comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
