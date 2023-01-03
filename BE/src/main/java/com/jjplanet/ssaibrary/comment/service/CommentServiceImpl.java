package com.jjplanet.ssaibrary.comment.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjplanet.ssaibrary.comment.domain.Comment;
import com.jjplanet.ssaibrary.comment.dto.FindAllCommentDTO;
import com.jjplanet.ssaibrary.comment.dto.InsertCommentDTO;
import com.jjplanet.ssaibrary.comment.dto.ReInsertCommentDTO;
import com.jjplanet.ssaibrary.comment.repository.CommentRepository;
import com.jjplanet.ssaibrary.community.domain.Community;
import com.jjplanet.ssaibrary.community.dto.FindAllCommunityDTO;
import com.jjplanet.ssaibrary.community.repository.CommunityRepository;
import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.member.repository.MemberRepository;

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
	public void insertComment(InsertCommentDTO c) {
		Optional<Member> member = memberRepository.findByNickname(c.getMemberNickname());
		Optional<Community> community = communityRepository.findOneById(c.getCommunityId());

		if (!member.isPresent()) {
			throw new NotFoundException("존재하지 않는 사용자입니다.");
		}
		Date now = new Date();
		c.setRegisterDate(now);
		c.setStatus('V');

		Comment comment = new Comment(community.get(), member.get(), c.getContent(), c.getRegisterDate(),
				c.getStatus());

		commentRepository.save(comment);

	}

	// 대댓글 작성
	@Override
	public void reInsertComment(ReInsertCommentDTO c) throws NotFoundException {
		Optional<Member> member = memberRepository.findByNickname(c.getMemberNickname());
		Optional<Community> community = communityRepository.findOneById(c.getCommunityId());
		Optional<Comment> parent = commentRepository.findOneById(c.getParentId());

		if (!member.isPresent()) {
			throw new NotFoundException("존재하지 않는 사용자입니다.");
		}
		Date now = new Date();
		c.setRegisterDate(now);
		c.setStatus('V');

		Comment comment = new Comment(community.get(), member.get(), c.getContent(), parent.get(), c.getRegisterDate(),
				c.getStatus());

		commentRepository.save(comment);

	}

	// 댓글 삭제
	@Override
	public void deleteComment(Long id) throws NotFoundException {
		Optional<Comment> comment = commentRepository.findOneById(id);

		if (!comment.isPresent()) {
			throw new NotFoundException("존재하지 않는 댓글입니다.");
		}

		comment.get().setStatus('D');

		commentRepository.save(comment.get());

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
