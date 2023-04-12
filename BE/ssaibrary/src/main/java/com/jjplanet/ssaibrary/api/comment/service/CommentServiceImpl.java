package com.jjplanet.ssaibrary.api.comment.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjplanet.ssaibrary.api.comment.domain.Comment;
import com.jjplanet.ssaibrary.api.comment.dto.InsertCommentDTO;
import com.jjplanet.ssaibrary.api.comment.dto.ReInsertCommentDTO;
import com.jjplanet.ssaibrary.api.comment.repository.CommentRepository;
import com.jjplanet.ssaibrary.api.community.domain.Community;
import com.jjplanet.ssaibrary.api.community.repository.CommunityRepository;
import com.jjplanet.ssaibrary.common.exception.NotFoundException;
import com.jjplanet.ssaibrary.api.member.domain.Member;
import com.jjplanet.ssaibrary.api.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final MemberRepository memberRepository;
	private final CommunityRepository communityRepository;
	private final CommentRepository commentRepository;

	// 댓글 작성
	@Override
	public void insertComment(InsertCommentDTO insertCommentDTO) {
		Member member = memberRepository.findByNickname(insertCommentDTO.getMemberNickname()).orElseThrow(NotFoundException::new);
		Community community = communityRepository.findById(insertCommentDTO.getCommunityId()).orElseThrow(NotFoundException::new);

		Date now = new Date();
		
		Comment comment = Comment.builder().insertCommentDTO(insertCommentDTO).member(member).community(community).now(now).build();

		commentRepository.save(comment);

	}

	// 대댓글 작성
	@Override
	public void reInsertComment(ReInsertCommentDTO reInsertCommentDTO) throws NotFoundException {
		Member member = memberRepository.findByNickname(reInsertCommentDTO.getMemberNickname()).orElseThrow(NotFoundException::new);
		Community community = communityRepository.findById(reInsertCommentDTO.getCommunityId()).orElseThrow(NotFoundException::new);
		Comment parentComment = commentRepository.findById(reInsertCommentDTO.getParentId()).orElseThrow(NotFoundException::new);
		
		Date now = new Date();
		
//		Comment comment = Comment.builder().reInsertCommentDTO(reInsertCommentDTO).member(member).community(community).parentComment(parentComment).now(now).build();
		
		reInsertCommentDTO.setStatus('V');
		
		Comment comment = new Comment(reInsertCommentDTO, member, community, parentComment, now);
		
		commentRepository.save(comment);

	}

	// 댓글 삭제
	@Override
	public void deleteComment(Long id) throws NotFoundException {
		Comment comment = commentRepository.findById(id).orElseThrow(NotFoundException::new);

		comment.deleteComment('D');

	}

//	
//	@Override
//	public Map<String, Object> findAllComment(Long communityId) throws NotFoundException {
//		List<Comment> list = commentRepository.findAllList(communityId);
//		List<FindAllCommentDTO> commentList;
////		
////		Map<String, Object> result = new HashMap<>();
////		
////		for(Comment c : list) {
////			FindAllCommentDTO output = new FindAllCommentDTO(c.getId(), c.getCommunityId().getId(), c.getMemberNickname().getNickname(), c.getContent(), c.getParentId().getId(), c.getLikeCount(), c.getRegisterDate(), c.getStatus(), c.getChildList());
////			commentList.add(output);
////		}
////		result.put("commentList", commentList);
////		return result;
//		
//		//댓글과 대댓글 그룹짓기
//		Map<Comment, List<Comment>> commentListMap = list.stream()
//													.filter(comment -> comment.getParentId() != null)
//													.collect(Collectors.groupingBy(Comment::getParentId));
//	
//		//댓글과 대댓글을 통해 FindAllCommentDTO 생성
//		commentList = commentListMap.keySet().stream()
//											.map(comment -> new FindAllCommentDTO(comment, commentListMap.get(comment)))
//											.toList();
//		
//	}

}
