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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ����
 * @author John
 *
 */
@Entity
@Table(name = "task")
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private int taskId;
	
	@Column(name = "task_name", nullable = false)
	private String taskName;
	
	@Column(name = "task_description")
	private String taskDescription;

	@Column(name = "task_time", nullable = false)
	private Date taskTime;
	
	//�������ͣ�1Ϊ�������� 2ΪС������Ĭ��Ϊ1
	@Column(name = "task_type", nullable = false)
	private int taskType;
	
	//������������һ���Ŷ�
	@ManyToOne(targetEntity = Team.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id", referencedColumnName = "team_id")
	private Team team;

	//Ҫ��ɸ�����ĳ�Ա
	@OneToMany(targetEntity = UserTask.class, mappedBy = "task", fetch = FetchType.LAZY)
	private Set<UserTask> userTasks = new HashSet<>();
	
	//�������Ӧ����ҵ
	@OneToMany(targetEntity = Work.class, mappedBy = "task", fetch = FetchType.LAZY)
	private Set<Work> works = new HashSet<Work>();

	//�������Ӧ��һ��С��
	@OneToMany(targetEntity = GroupTask.class, mappedBy = "task", fetch = FetchType.LAZY)
	private Set<GroupTask> groupTasks = new HashSet<>();

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Date getTaskTime() {
		return taskTime;
	}

	public void setTaskTime(Date taskTime) {
		this.taskTime = taskTime;
	}

	public int getTaskType() {
		return taskType;
	}

	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Set<UserTask> getUserTasks() {
		return userTasks;
	}

	public void setUserTasks(Set<UserTask> userTasks) {
		this.userTasks = userTasks;
	}

	public Set<Work> getWorks() {
		return works;
	}

	public void setWorks(Set<Work> works) {
		this.works = works;
	}

	public Set<GroupTask> getGroupTasks() {
		return groupTasks;
	}

	public void setGroupTasks(Set<GroupTask> groupTasks) {
		this.groupTasks = groupTasks;
	}
	
}
