package com.jjplanet.ssaibrary.comment.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jjplanet.ssaibrary.comment.dto.InsertCommentDTO;
import com.jjplanet.ssaibrary.comment.dto.ReInsertCommentDTO;
import com.jjplanet.ssaibrary.community.domain.Community;
import com.jjplanet.ssaibrary.member.domain.Member;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED) //모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본생성자 생성
@Getter //getter 생성
public class Comment implements Serializable{

	//댓글번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//글번호
	@ManyToOne(cascade = CascadeType.REMOVE, targetEntity = Community.class)
	@JoinColumn(name = "community_id")
	private Community community;

	//작성자닉네임
	@ManyToOne(targetEntity = Member.class, cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "member_nickname", referencedColumnName = "nickname")
	private Member member;

	//내용
	@Column(nullable = false, length = 2000)
	private String content;

	//부모댓글
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Comment parentComment;

	//자식댓글
	@ElementCollection
	@OneToMany(mappedBy = "parentComment")
	private List<Comment> childList = new ArrayList<>();

	//좋아요수
	@Column(name = "like_count", nullable = true, columnDefinition = "DEFAULT 0")
	private int likeCount;

	//등록일시
	@Column(name = "register_date", nullable = false, columnDefinition = "DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;

	//상태(V:노출,D:삭제,B:신고)
	@Setter
	@Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'V'")
	private char status;
	
	//댓글 작성
	@Builder
	public Comment(InsertCommentDTO insertCommentDTO, Community community, Member member, Date now) {
		this.community = community;
		this.member = member;
		this.content = insertCommentDTO.getContent();
		this.registerDate = now;
		this.status = 'V';
	}
	
	//대댓글 작성
	@Builder 
	public Comment(ReInsertCommentDTO reInsertCommentDTO, Member member, Community community, Comment parentComment, Date now) {
		this.community = community;
		this.member = member;
		this.content = reInsertCommentDTO.getContent();
		this.parentComment = parentComment;
		parentComment.addChild(this);
		this.registerDate = now;
		this.status = 'V';
	}
	
	public void addChild(Comment child) {
		childList.add(child);
		System.out.println(childList.size());
		for(int i=0; i<childList.size(); i++) {
			System.out.println("부모id : "+childList.get(i).parentComment.getId());
			System.out.println("id : "+childList.get(i).id);
			System.out.println("게시글id : "+childList.get(i).community.getId());
			System.out.println("내용 : "+childList.get(i).content);
			System.out.println("조회수 : "+childList.get(i).likeCount);
			System.out.println("작성자 : "+childList.get(i).member.getNickname());
			System.out.println("등록일 : "+childList.get(i).registerDate);
			System.out.println("상태 : "+childList.get(i).status);
			System.out.println("자식댓글사이즈 : "+childList.get(i).childList.size());
			
			
		}
	}
	
	//댓글 삭제
	public void deleteComment(char status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", community=" + community + ", member=" + member
				+ ", content=" + content + ", parentComment=" + parentComment + ", childList=" + childList + ", likeCount="
				+ likeCount + ", registerDate=" + registerDate + ", status=" + status + "]";
	}



}