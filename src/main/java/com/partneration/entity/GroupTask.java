package com.partneration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 小组任务
 * @author John
 *
 */
@Entity
@Table(name = "group_task")
public class GroupTask implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gtask_id")
	private int groupTaskId;
	
	//该任务对应哪一个小组
	@ManyToOne(targetEntity = Group.class)
	@JoinColumn(name = "group_id", referencedColumnName = "group_id")
	private Group group;
	
	//该小组对应的任务
	@ManyToOne(targetEntity = Task.class)
	@JoinColumn(name = "task_id", referencedColumnName = "task_id")
	private Task task;

	public int getGroupTaskId() {
		return groupTaskId;
	}

	public void setGroupTaskId(int groupTaskId) {
		this.groupTaskId = groupTaskId;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
}
