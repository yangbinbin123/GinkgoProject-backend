package com.partneration.json;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class RegisterJson {

	@NotNull(message = "ѧ�Ż�ְ���Ų���Ϊ��")
	private String userId;
	
	@NotNull(message = "���벻��Ϊ��")
	private String password;
	
	@NotNull(message = "���䲻��Ϊ��")
	@Email(message = "�����ʽ����ȷ")
	private String email;
	
	@NotNull(message = "��������Ϊ��")
	private String name;
	
	@NotNull(message = "�绰���벻��Ϊ��")
	private String phoneNum;
	
	//@NotNull(message = "ѧУ����Ϊ��")
	private String school;
	
	//@NotNull(message = "ѧԺ����Ϊ��")
	private String college;
	
	//@NotNull(message = "רҵ����Ϊ��")
	private String specialty;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
}
