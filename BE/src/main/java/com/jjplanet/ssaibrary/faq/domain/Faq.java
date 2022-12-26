package com.jjplanet.ssaibrary.faq.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jjplanet.ssaibrary.inquiry.domain.Inquiry;

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
public class Faq {
	
	//�۹�ȣ
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//����
	@Column(nullable = false, length = 2000)
	private String question;
	
	//�亯
	@Column(nullable = false, length = 2000)
	private String answer;
	
	//����(V:����,D:����)
	@Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'V'")
	private char status;

}
