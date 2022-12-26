package com.jjplanet.ssaibrary.comment.domain;

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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED) //��� �ʵ� ���� �Ķ���ͷ� �޴� �����ڸ� ����
@NoArgsConstructor(access = AccessLevel.PROTECTED) //�⺻������ ����
@Getter //getter ����
public class Comment {
	
	//��۹�ȣ
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//�۹�ȣ
	@ManyToOne(cascade = CascadeType.REMOVE, targetEntity = Community.class)
	@JoinColumn(name = "community_id")
	//@Column(name = "community_id", nullable = false)
	private int communityId;
	
	//�ۼ��ڴг���
	@ManyToOne(targetEntity = Member.class, cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "member_nickname", referencedColumnName = "nickname")
	//@Column(name = "member_nickname", nullable = false, length = 20)
	private String memberNickname;
	
	//����
	@Column(nullable = false, length = 2000)
	private String content;
	
	//�θ���
	@Column(name = "parent_id", nullable = false, columnDefinition = "DEFAULT 0")
	private int parentId;
	
	//��۰���(����)
	@Column(name = "depth_no", nullable = false, columnDefinition = "DEFAULT 0")
	private int depthNo;
	
	//���ļ���
	@Column(name = "order_no", nullable = false, columnDefinition = "DEFAULT 0")
	private int orderNo;
	
	//���ƿ��
	@Column(name = "like_count", nullable = true, columnDefinition = "DEFAULT 0")
	private int likeCount;
	
	//����Ͻ�
	@Column(name = "register_date", nullable = false, columnDefinition = "DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;
	
	//����(V:����,D:����,B:�Ű�)
	@Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'V'")
	private char status;
	

}
