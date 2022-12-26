package com.jjplanet.ssaibrary.notice.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jjplanet.ssaibrary.community.domain.Community;
import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.notice.dto.NoticeRequestDTO;

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
public class Notice {
	
	//글번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto_Increment를 지원해줌.
	private Long id;
	
	//작성자아이디
	//@Column(name = "member_id", nullable = false, length = 20)
	@ManyToOne(targetEntity = Member.class, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "member_id") //기본키를 참조하므로 referencedColumnName 생략함.
	private Member memberId;
	
	//제목
	@Setter
	@Column(nullable = false, length = 100)
	private String title;
	
	//내용
	@Setter
	@Column(nullable = false, length = 2000)
	private String content;
	
	//조회수
	@Column(name = "hit_count", nullable = false, columnDefinition = "DEFAULT 0")
	private int hitCount;
	
	//등록일시
	@Column(name = "register_date", nullable = false, columnDefinition = "DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;
	
	//수정일시
	@Setter
	@Column(name = "update_date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	//주요공지사항여부(Y:주요공지사항,N:일반공지사항)
	@Setter
	@Column(name = "is_priority", nullable = false, columnDefinition = "CHAR(1) DEFAULT 'N'")
	private char isPriority;
	
	//상태(V:노출,D:삭제)
	@Setter
	@Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'V'")
	private char status;
	
	//글작성
	@Builder
	public Notice(Member memberId, String title, String content, Date registerDate, char isPriority, char status) {
		this.memberId = memberId;
		this.title = title;
		this.content = content;
		this.registerDate = registerDate;
		this.isPriority = isPriority;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", memberId=" + memberId + ", title=" + title + ", content=" + content
				+ ", hitCount=" + hitCount + ", registerDate=" + registerDate + ", updateDate=" + updateDate
				+ ", isPriority=" + isPriority + ", status=" + status + "]";
	}
	
	
	
}
