package com.jjplanet.ssaibrary.comment.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjplanet.ssaibrary.comment.dto.InsertCommentDTO;
import com.jjplanet.ssaibrary.comment.dto.ReInsertCommentDTO;
import com.jjplanet.ssaibrary.comment.service.CommentServiceImpl;
import com.jjplanet.ssaibrary.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
	
	public static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	private static final String SUCCESS = "success";
	
	private final CommentServiceImpl commentService;
	
	//댓글 작성
	@PostMapping
	public ResponseEntity<String> insertComment(InsertCommentDTO insertCommentDTO) throws NotFoundException{
		commentService.insertComment(insertCommentDTO);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	//대댓글 작성
	@PostMapping("/reply")
	public ResponseEntity<String> reInsertComment(ReInsertCommentDTO reInsertCommentDTO) throws NotFoundException{
		commentService.reInsertComment(reInsertCommentDTO);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
//	//댓글 가져오기
//	@GetMapping("/{communityId}")
//	public ResponseEntity<Map<String, Object>> findAllComment(@PathVariable Long communityId) throws NotFoundException{
//		return new ResponseEntity<Map<String,Object>>(commentService.findAllComment(communityId), HttpStatus.ACCEPTED);
//	}
	
	//댓글 삭제하기
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteComment(@PathVariable("id") Long id) throws NotFoundException{
		commentService.deleteComment(id);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
}
