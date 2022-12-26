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
@AllArgsConstructor(access = AccessLevel.PROTECTED) //��� �ʵ� ���� �Ķ���ͷ� �޴� �����ڸ� ����
@NoArgsConstructor(access = AccessLevel.PROTECTED) //�⺻������ ����
@Getter //getter ����
public class Notice {
	
	//�۹�ȣ
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto_Increment�� ��������.
	private Long id;
	
	//�ۼ��ھ��̵�
	//@Column(name = "member_id", nullable = false, length = 20)
	@ManyToOne(targetEntity = Member.class, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "member_id") //�⺻Ű�� �����ϹǷ� referencedColumnName ������.
	private Member memberId;
	
	//����
	@Setter
	@Column(nullable = false, length = 100)
	private String title;
	
	//����
	@Setter
	@Column(nullable = false, length = 2000)
	private String content;
	
	//��ȸ��
	@Column(name = "hit_count", nullable = false, columnDefinition = "DEFAULT 0")
	private int hitCount;
	
	//����Ͻ�
	@Column(name = "register_date", nullable = false, columnDefinition = "DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;
	
	//�����Ͻ�
	@Setter
	@Column(name = "update_date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	//�ֿ�������׿���(Y:�ֿ��������,N:�Ϲݰ�������)
	@Setter
	@Column(name = "is_priority", nullable = false, columnDefinition = "CHAR(1) DEFAULT 'N'")
	private char isPriority;
	
	//����(V:����,D:����)
	@Setter
	@Column(nullable = false, columnDefinition = "CHAR(1) DEFAULT 'V'")
	private char status;
	
	//���ۼ�
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
