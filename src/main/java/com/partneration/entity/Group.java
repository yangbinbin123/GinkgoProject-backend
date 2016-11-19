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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 小组实体类
 * @author John
 *
 */

@Entity
@Table(name = "group_")
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id")
	private int groupId;
	
	@Column(name = "group_leader", nullable = false)
	private String groupLeader;
	
	@Column(name = "group_name", nullable = false)
	private String groupName;
	
	@Column(name = "group_time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date groupTime;
	
	//小组属于哪一个团队
	@ManyToOne(targetEntity = Team.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id", referencedColumnName = "team_id")
	private Team team;
	
	//该小组有哪些任务
	@OneToMany(targetEntity = GroupTask.class, mappedBy = "group", fetch = FetchType.LAZY)
	private Set<GroupTask> tasks = new HashSet<>();

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupLeader() {
		return groupLeader;
	}

	public void setGroupLeader(String groupLeader) {
		this.groupLeader = groupLeader;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getGroupTime() {
		return groupTime;
	}

	public void setGroupTime(Date groupTime) {
		this.groupTime = groupTime;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Set<GroupTask> getTasks() {
		return tasks;
	}

	public void setTasks(Set<GroupTask> tasks) {
		this.tasks = tasks;
	}
	
}
