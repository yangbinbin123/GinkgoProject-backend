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
 * 作业
 * @author John
 *
 */
@Entity
@Table(name = "work")
public class Work implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "work_id")
	private int workId;
	
	@Column(name = "work_content")
	private String workContent;

	@Column(name = "work_file")
	private String workFile;
	
	//该作业对应的任务
	@ManyToOne(targetEntity = Task.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "task_id", referencedColumnName = "task_id")
	private Task task;
	
	//该作业对应的用户
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "uuid", referencedColumnName = "uuid")
	private User user;

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public String getWorkFile() {
		return workFile;
	}

	public void setWorkFile(String workFile) {
		this.workFile = workFile;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
