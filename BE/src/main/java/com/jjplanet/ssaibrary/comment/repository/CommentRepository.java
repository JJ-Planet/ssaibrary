package com.jjplanet.ssaibrary.comment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jjplanet.ssaibrary.comment.domain.Comment;

import io.swagger.v3.oas.annotations.Parameter;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	

}
