package com.jjplanet.ssaibrary.member.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jjplanet.ssaibrary.member.dto.MemberRequestDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED) //��� �ʵ� ���� �Ķ���ͷ� �޴� �����ڸ� ����
@NoArgsConstructor(access = AccessLevel.PROTECTED) //�⺻������ ����
@Getter //getter ����
public class Member {

	
	//���̵�(��ȭ��ȣ)
	@Id
	@Column(nullable = false, length = 20)
	private String id;
	
	//��й�ȣ
	@Setter
	@Column(nullable = false, length = 255)
	private String password;
	
	//jwt��ū
	@Column(name = "refresh_token", nullable = true, length = 255)
	private String refreshToken;
	
	//�̸�
	@Setter
	@Column(nullable = false, length = 20)
	private String name;
	
	//�г���
	@Setter
	@Column(nullable = false, length = 20, unique = true)
	private String nickname;
	
	//�����̹�����
	@Column(name = "origin_image", nullable = false, length = 255, columnDefinition = "DEFAULT 'default.jpg'")
	private String originImage;
	
	//�����̹�����
	@Column(name = "save_image", nullable = false, length = 255, columnDefinition = "DEFAULT 'default.jpg'")
	private String saveImage;
	
	//�����Ͻ�
	@Column(name = "join_date", nullable = false, columnDefinition = "DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date joinDate;
	
	//Ż���Ͻ�
	@Setter
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "exit_date", nullable = true)
	private Date exitDate; 
	
	//�����ڿ���(Y:������,N:�Ϲ�ȸ��)
	@Column(name = "is_admin", nullable = false, columnDefinition = "CHAR(1) DEFAULT 'N'")
	private char isAdmin;

	//����(A:Ȱ������,X:Ż�����)
	@Setter
	@Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'A'")
	private char status;
	

	//ȸ������
	@Builder
	public Member(String id, String password, String name, String nickname, String originImage, String saveImage, Date joinDate, char isAdmin, char status) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.originImage = originImage;
		this.saveImage = saveImage;
		this.joinDate = joinDate;
		this.isAdmin = isAdmin;
		this.status = status;
	}
	
	//ȸ����������
	@Builder
	public Member(String name, String nickname, String password) {
		this.name = name;
		this.nickname = nickname;
		this.password = password;
	}

	
	

}
