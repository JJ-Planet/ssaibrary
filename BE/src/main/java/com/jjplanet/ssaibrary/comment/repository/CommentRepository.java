package com.jjplanet.ssaibrary.comment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jjplanet.ssaibrary.comment.domain.Comment;

import io.swagger.v3.oas.annotations.Parameter;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	//@Query(value = "select * from Comment where id=:id", nativeQuery = true)
	Optional<Comment> findOneById(@Param("id") Long id);

	// 전체 목록 불러오기
	@Query(value = "select * from Comment where community_id=:community_id", nativeQuery = true)
	List<Comment> findAllList(@Param("community_id")Long communityId);
	

}
