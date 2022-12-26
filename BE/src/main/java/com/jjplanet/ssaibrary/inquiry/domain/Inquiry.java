package com.jjplanet.ssaibrary.inquiry.domain;

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

import com.jjplanet.ssaibrary.member.domain.Member;
import com.jjplanet.ssaibrary.notice.domain.Notice;

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
public class Inquiry {
	
	//�۹�ȣ
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//�ۼ��ڴг���
	//@Column(name = "member_nickname", nullable = false, length = 20)
	@ManyToOne(targetEntity = Member.class, cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "member_nickname", referencedColumnName = "nickname")
	private String memberNickname;
	
	//����
	@Column(nullable = false, length = 100)
	private String title;
	
	//����
	@Column(nullable = false, length = 2000)
	private String question;
	
	//�亯
	@Column(nullable = true, length = 2000)
	private String answer;
	
	//����Ͻ�
	@Column(name = "register_date", nullable = false, columnDefinition = "DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;
	
	//����(W:�亯���,C:�亯�Ϸ�,D:����)
	@Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'W'")
	private char status;

}
