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
 * 用户的任务表
 * @author John
 *
 */
@Entity
@Table(name = "user_task")
public class UserTask implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "utask_id")
	private int userTaskId;
	
	//任务所对应的用户
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "uuid", referencedColumnName = "uuid")
	private User user;
	
	//该成员对应的任务
	@ManyToOne(targetEntity = Task.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "task_id", referencedColumnName = "task_id")
	private Task task;

	public int getUserTaskId() {
		return userTaskId;
	}

	public void setUserTaskId(int userTaskId) {
		this.userTaskId = userTaskId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
}
