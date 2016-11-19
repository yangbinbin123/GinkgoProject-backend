package com.partneration.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 用户实体类
 * @author John
 *
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String uuid;
	
	//学生学号或老师的职工号
	@Column(nullable = false)
	private String userId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String password;
	
	private String school;
	
	private String college;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(name = "phone_num", nullable = false)
	private String phoneNum;
	
	private String specialty;
	
	@Column(name = "validate_code", nullable = false)
	private String validateCode;
	
	@Column(name = "created_time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;
	
	//用户账号的状态：1为还未验证，2为可用，3为禁用
	private int status;

	//通知-一对多
	@OneToMany(targetEntity = UserNotice.class, mappedBy = "user", fetch = FetchType.LAZY)
	private Set<UserNotice> userNotices = new HashSet<>();

	//该用户创建了哪些团队
	@OneToMany(targetEntity = Team.class, mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Team> teams = new HashSet<>();

	//该用户参加了哪些团队
	@OneToMany(targetEntity = UserTeam.class, mappedBy = "user", fetch = FetchType.LAZY)
	private Set<UserTeam> UserTeam =  new HashSet<>();
	
	//该用户有哪些任务
	@OneToMany(targetEntity = UserTask.class, mappedBy = "user", fetch = FetchType.LAZY)
	private Set<UserTask> userTasks = new HashSet<>();
	
	//该用户对应的作业
	@OneToMany(targetEntity = Work.class, mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Work> works = new HashSet<>();
	
	//该用户对应表格的答案
	@OneToMany(targetEntity = Answer.class, mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Answer> answers = new HashSet<>();

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Set<UserNotice> getUserNotices() {
		return userNotices;
	}

	public void setUserNotices(Set<UserNotice> userNotices) {
		this.userNotices = userNotices;
	}

	public Set<Team> getTeams() {
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	public Set<UserTeam> getUserTeam() {
		return UserTeam;
	}

	public void setUserTeam(Set<UserTeam> userTeam) {
		UserTeam = userTeam;
	}

	public Set<UserTask> getUserTasks() {
		return userTasks;
	}

	public void setUserTasks(Set<UserTask> userTasks) {
		this.userTasks = userTasks;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public Set<Work> getWorks() {
		return works;
	}

	public void setWorks(Set<Work> works) {
		this.works = works;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date date) {
		this.createdTime = date;
	}
	
}
