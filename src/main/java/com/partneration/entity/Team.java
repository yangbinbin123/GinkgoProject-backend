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
 * 团队实体类
 * @author John
 *
 */
@Entity
@Table(name = "team")
public class Team implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private int teamId;
	
	@Column(name = "team_name", nullable = false)
	private String teamName;
	
	@Column(name = "team_description")
	private String teamDescription;
	
	@Column(name = "team_createdTime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date teamCreatedTime;
	
	//是否能够组队
	@Column(name = "team_canGroup", nullable = false)
	private int canGroup;
	
	//团队创建者
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_uuid", referencedColumnName = "uuid")
	private User user;
	
	//该团队有哪些成员
	@OneToMany(targetEntity = UserTeam.class, mappedBy = "team", fetch = FetchType.LAZY)
	private Set<UserTeam> userTeam =  new HashSet<>();
	
	//该团队有哪些小组
	@OneToMany(targetEntity = Group.class, mappedBy = "team", fetch = FetchType.LAZY)
	private Set<Group> groups = new HashSet<>();
	
	//该团队有哪些任务
	@OneToMany(targetEntity = Task.class, mappedBy = "team", fetch = FetchType.LAZY)
	private Set<Task> tasks = new HashSet<>();

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamDescription() {
		return teamDescription;
	}

	public void setTeamDescription(String teamDescription) {
		this.teamDescription = teamDescription;
	}

	public Date getTeamCreatedTime() {
		return teamCreatedTime;
	}

	public void setTeamCreatedTime(Date teamCreatedTime) {
		this.teamCreatedTime = teamCreatedTime;
	}

	public int getCanGroup() {
		return canGroup;
	}

	public void setCanGroup(int canGroup) {
		this.canGroup = canGroup;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<UserTeam> getUserTeam() {
		return userTeam;
	}

	public void setUserTeam(Set<UserTeam> userTeam) {
		this.userTeam = userTeam;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
}
