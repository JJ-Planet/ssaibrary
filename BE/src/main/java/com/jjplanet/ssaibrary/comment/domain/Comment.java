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
	private Community communityId;

	//작성자닉네임
	@ManyToOne(targetEntity = Member.class, cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "member_nickname", referencedColumnName = "nickname")
	private Member memberNickname;

	//내용
	@Column(nullable = false, length = 2000)
	private String content;

	//부모댓글
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Comment parentId;

	//자식댓글
	@ElementCollection
	@OneToMany(mappedBy = "parentId")
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
	
	//댓글
	@Builder
	public Comment(Community communityId, Member memberNickname, String content, Date registerDate, char status) {
		this.communityId = communityId;
		this.memberNickname = memberNickname;
		this.content = content;
		this.registerDate = registerDate;
		this.status = status;
	}
	
	//대댓글
	@Builder
	public Comment(Community communityId, Member memberNickname, String content, Comment parentId, Date registerDate, char status) {
		this.communityId = communityId;
		this.memberNickname = memberNickname;
		this.content = content;
		this.parentId = parentId;
		parentId.addChild(this);
		this.registerDate = registerDate;
		this.status = status;
	}
	
	public void addChild(Comment child) {
		childList.add(child);
		System.out.println(childList.size());
		for(int i=0; i<childList.size(); i++) {
			System.out.println("부모id : "+childList.get(i).parentId.getId());
			System.out.println("id : "+childList.get(i).id);
			System.out.println("게시글id : "+childList.get(i).communityId.getId());
			System.out.println("내용 : "+childList.get(i).content);
			System.out.println("조회수 : "+childList.get(i).likeCount);
			System.out.println("작성자 : "+childList.get(i).memberNickname.getNickname());
			System.out.println("등록일 : "+childList.get(i).registerDate);
			System.out.println("상태 : "+childList.get(i).status);
			System.out.println("자식댓글사이즈 : "+childList.get(i).childList.size());
			
			
		}
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", communityId=" + communityId + ", memberNickname=" + memberNickname
				+ ", content=" + content + ", parentId=" + parentId + ", childList=" + childList + ", likeCount="
				+ likeCount + ", registerDate=" + registerDate + ", status=" + status + "]";
	}



}