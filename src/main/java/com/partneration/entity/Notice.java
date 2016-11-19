package com.partneration.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 系统消息的通知实体类
 * @author John
 *
 */
@Entity
@Table(name = "notice")
public class Notice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "notice_id")
	private int noticeId;
	
	@Column(name = "notice_content", nullable = false)
	private String content;
	
	@Column(nullable = false, name = "notice_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date noticeTime;
	
	@Column(name = "notice_title", nullable = false)
	private String noticeTitle;
	
	//创建者，默认system
	@Column(nullable = false)
	private String uuid;
	
	//通知对应用户通知表
	@OneToMany(targetEntity = UserNotice.class, mappedBy= "notice", fetch = FetchType.LAZY)
	private Set<UserNotice> userNotices = new HashSet<>();

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<UserNotice> getUserNotices() {
		return userNotices;
	}

	public void setUserNotices(Set<UserNotice> userNotices) {
		this.userNotices = userNotices;
	}

	public Date getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	
}
