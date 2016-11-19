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
 * �û�ʵ����
 * @author John
 *
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String uuid;
	
	//ѧ��ѧ�Ż���ʦ��ְ����
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
	
	//�û��˺ŵ�״̬��1Ϊ��δ��֤��2Ϊ���ã�3Ϊ����
	private int status;

	//֪ͨ-һ�Զ�
	@OneToMany(targetEntity = UserNotice.class, mappedBy = "user", fetch = FetchType.LAZY)
	private Set<UserNotice> userNotices = new HashSet<>();

	//���û���������Щ�Ŷ�
	@OneToMany(targetEntity = Team.class, mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Team> teams = new HashSet<>();

	//���û��μ�����Щ�Ŷ�
	@OneToMany(targetEntity = UserTeam.class, mappedBy = "user", fetch = FetchType.LAZY)
	private Set<UserTeam> UserTeam =  new HashSet<>();
	
	//���û�����Щ����
	@OneToMany(targetEntity = UserTask.class, mappedBy = "user", fetch = FetchType.LAZY)
	private Set<UserTask> userTasks = new HashSet<>();
	
	//���û���Ӧ����ҵ
	@OneToMany(targetEntity = Work.class, mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Work> works = new HashSet<>();
	
	//���û���Ӧ���Ĵ�
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
