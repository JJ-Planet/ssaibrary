package com.jjplanet.ssaibrary.community.domain;

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

import com.jjplanet.ssaibrary.community.dto.CommunityRequestDTO;
import com.jjplanet.ssaibrary.member.domain.Member;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * pk�� �ƴ� �÷��� ������ �� referencedColumnName�� ��!! ���������.
 * �ֳ��ϸ�, referencedColumnName �⺻���� pk��  
 * ������ pk�� �����ϴ� ������ �ν���.
 *  (memberNickname ������ @JoinColumn ����)
 *  
 *  String Ÿ���� ������ @Column ���ٰ� length�� �� ������� ��.
 */

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED) // ��� �ʵ� ���� �Ķ���ͷ� �޴� �����ڸ� ����
@NoArgsConstructor(access = AccessLevel.PROTECTED) // �⺻������ ����
@Getter // getter ����
public class Community {

	// �۹�ȣ
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_Increment�� ��������.
	private Long id;

	// �ۼ��� �г���
	//@Column(name = "member_nickname", nullable = false, length = 20)
	@ManyToOne(targetEntity = Member.class, cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "member_nickname", referencedColumnName = "nickname")
	private Member memberNickname;

	// ����
	@Column(nullable = false, length = 100)
	private String title;

	// ����
	@Column(nullable = false, length = 2000)
	private String content;

	// ��ȸ��
	@Column(name = "hit_count", nullable = true, columnDefinition = "DEFAULT 0")
	private int hitCount;

	// ���ƿ��
	@Column(name = "like_count", nullable = true, columnDefinition = "DEFAULT 0")
	private int likeCount;

	// ����Ͻ�
	@Column(name = "register_date", nullable = false, columnDefinition = "DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;

	// �����Ͻ�
	@Column(name = "update_date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	// ����(V:����,D:����,B:�Ű�)
	@Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'V'")
	private char status;
	
	//���ۼ�
	@Builder
	public Community(Member memberNickname, String title, String content, Date registerDate, char status) {
		this.memberNickname = memberNickname;
		this.title = title;
		this.content = content;
		this.registerDate = registerDate;
		this.status = status;
	}

}
