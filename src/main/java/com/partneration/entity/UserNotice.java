package com.partneration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 每个用户的通知实体类
 * @author John
 *
 */
@Entity
@Table(name = "user_notice")
public class UserNotice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//通知的状态信息：1为未读，2为已读。默认为1
	@Column(nullable = false, name = "un_status")
	private int unStatus;
	
	//用户通知表与用户为多对一
	@ManyToOne(targetEntity = Notice.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "notice_id", referencedColumnName = "notice_id")
	private Notice notice;
	
	//用户通知表与用户为多对一
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "uuid", referencedColumnName = "uuid")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUnStatus() {
		return unStatus;
	}

	public void setUnStatus(int unStatus) {
		this.unStatus = unStatus;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
